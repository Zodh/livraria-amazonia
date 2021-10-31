package br.com.unip.dao;

import br.com.unip.dao.base.BaseDAO;
import br.com.unip.dao.base.GenericDAO;
import br.com.unip.model.entity.BookAuthor;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Integer> implements
    GenericDAO<BookAuthor, Integer> {

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }
}
