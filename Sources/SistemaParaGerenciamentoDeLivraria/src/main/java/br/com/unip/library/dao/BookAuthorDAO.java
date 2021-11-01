package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.model.entity.BookAuthor;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Integer> implements
    GenericDAO<BookAuthor, Integer> {

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }
}
