package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.model.entity.BookAuthor;
import java.net.Proxy.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Type> implements
    GenericDAO<BookAuthor, Type> {

  private static final Logger log = LoggerFactory.getLogger(BookAuthorDAO.class);

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }

  public void create(BookAuthor bookAuthor) throws Exception {
    openConn();
    var sql = "insert into booksauthors (isbn, author_id, seq_no) values (?, ?, ?)";
    try {
      var statement = connection.prepareStatement(sql);
      statement.setString(1, bookAuthor.getIsbn());
      statement.setInt(2, bookAuthor.getAuthorId());
      statement.setInt(3, bookAuthor.getSeqNo());
      log.info("Inserting data into the Book Authors table");
      statement.execute();
      statement.close();
    } catch (Exception exception) {
      throw new Exception(
          "Error trying to save a new Book Author in the database. " + exception.getMessage());
    } finally {
      closeConn();
    }
  }
}
