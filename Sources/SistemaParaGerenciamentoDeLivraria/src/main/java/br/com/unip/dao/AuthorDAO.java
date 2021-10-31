package br.com.unip.dao;

import br.com.unip.dao.base.BaseDAO;
import br.com.unip.dao.base.GenericDAO;
import br.com.unip.model.entity.Author;

public class AuthorDAO extends BaseDAO<Author, Integer> implements
    GenericDAO<Author, Integer> {

  public AuthorDAO() {
    super(Author.class);
  }
}
