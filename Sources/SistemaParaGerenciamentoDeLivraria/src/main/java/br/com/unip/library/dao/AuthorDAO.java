package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.model.entity.Author;

public class AuthorDAO extends BaseDAO<Author, Integer> implements
    GenericDAO<Author, Integer> {

  public AuthorDAO() {
    super(Author.class);
  }
}
