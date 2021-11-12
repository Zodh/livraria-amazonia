package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Book;

public class BookDAO extends BaseDAO<Book, String> implements GenericDAO<Book, String> {

  public BookDAO() {
    super(Book.class);
  }

  public Book findByIsbn(String isbn) throws Exception {
    try {
      beginTransaction();
      var session = HibernateUtil.getSession();
      var book = session.get(Book.class, isbn);
      commitTransaction();
      return book;
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to find a Book by ISBN.");
    } finally {
      endTransaction();
    }
  }

}
