package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorDAO extends BaseDAO<Author, Integer> implements
    GenericDAO<Author, Integer> {

  private static final Logger log = LoggerFactory.getLogger(AuthorDAO.class);

  public AuthorDAO() {
    super(Author.class);
  }

  public void create(Author author) throws Exception {
    openConn();
    var sql = "insert into authors (name, fname) values (?,?)";
    try {
      var statement = connection.prepareStatement(sql);
      statement.setString(1, author.getName());
      statement.setString(2, author.getFname());
      log.info("Inserting data into the Authors table");
      statement.execute();
      statement.close();
    } catch (Exception exception) {
      throw new Exception(
          "Error trying to save a new author in the database. " + exception.getMessage());
    } finally {
      log.info("Ending connection");
      closeConn();
    }
  }

  public void deleteAuthorAndBatchDeleteBookAuthors(Integer id) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info(String.format("Trying to execute bulk delete for Author ID %d on BookAuthors.", id));
      var bookAuthorQuery = "delete BookAuthor ba where ba.authorId = :id";
      HibernateUtil.getSession()
          .createQuery(bookAuthorQuery)
          .setParameter("id", id)
          .executeUpdate();
      log.info("Deleting entity in the database");
      var authorQuery = "delete Author a where a.authorId = :id";
      HibernateUtil.getSession()
          .createQuery(authorQuery)
          .setParameter("id", id)
          .executeUpdate();
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to delete an Author." + exception.getMessage());
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  public Author findById(Integer id) {
    beginTransaction();
    var session = HibernateUtil.getSession();
    var author = session.get(Author.class, id);
    endTransaction();
    return author;
  }
}
