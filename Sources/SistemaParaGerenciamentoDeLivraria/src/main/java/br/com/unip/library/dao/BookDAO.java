package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookDAO extends BaseDAO<Book, String> implements GenericDAO<Book, String> {

  private static final Logger log = LoggerFactory.getLogger(BookDAO.class);

  public BookDAO() {
    super(Book.class);
  }

  public void deleteBookAndBatchDeleteBookAuthors(String isbn) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info(String.format("Trying to execute bulk delete for isbn %s on BookAuthors.", isbn));
      var bookAuthorQuery = "delete BookAuthor ba where ba.isbn = :isbn";
      HibernateUtil.getSession()
          .createQuery(bookAuthorQuery)
          .setParameter("isbn", isbn)
          .executeUpdate();
      log.info("Deleting entity in the database");
      var bookQuery = "delete Book b where b.isbn = :isbn";
      HibernateUtil.getSession()
          .createQuery(bookQuery)
          .setParameter("isbn", isbn)
          .executeUpdate();
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to delete a Book." + exception.getMessage());
    }
    finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  public Book findByIsbn(String isbn) {
    beginTransaction();
    var session = HibernateUtil.getSession();
    var book = session.get(Book.class, isbn);
    endTransaction();
    return book;
  }

}
