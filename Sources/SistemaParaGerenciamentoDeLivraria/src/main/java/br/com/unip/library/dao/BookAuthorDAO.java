package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Author;
import br.com.unip.library.model.entity.Book;
import br.com.unip.library.model.entity.BookAuthor;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Integer> implements
    GenericDAO<BookAuthor, Integer> {

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }

  public Author findByAuthorId(Integer id) {
    beginTransaction();
    var session = HibernateUtil.getSession();
    var author = session.get(Author.class, id);
    endTransaction();
    return author;
  }

  public Book findByBookIsbn(String isbn) {
    beginTransaction();
    var session = HibernateUtil.getSession();
    var book = session.get(Book.class, isbn);
    endTransaction();
    return book;
  }
}
