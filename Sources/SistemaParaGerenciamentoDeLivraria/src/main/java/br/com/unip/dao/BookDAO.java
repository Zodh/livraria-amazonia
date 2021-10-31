package br.com.unip.dao;

import br.com.unip.dao.base.BaseDAO;
import br.com.unip.dao.base.GenericDAO;
import br.com.unip.dao.base.HibernateUtil;
import br.com.unip.model.entity.Book;

public class BookDAO extends BaseDAO<Book, String> implements GenericDAO<Book, String> {

  public BookDAO() {
    super(Book.class);
  }

  public Book findById(String isbn){
    beginTransaction();
    var session = HibernateUtil.getSession();
    var book = session.get(Book.class, isbn);
    endTransaction();
    return book;
  }

}
