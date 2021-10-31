package br.com.unip.dao.base;

import br.com.unip.dao.AuthorDAO;
import br.com.unip.dao.BookAuthorDAO;
import br.com.unip.dao.BookDAO;
import br.com.unip.dao.PublisherDAO;

public class HibernateDAOFactory extends DAOFactory {

  @Override
  public AuthorDAO getAuthorDAO() {
    return new AuthorDAO();
  }

  @Override
  public BookAuthorDAO getBookAuthorDAO() {
    return new BookAuthorDAO();
  }

  @Override
  public BookDAO getBookDAO() {
    return new BookDAO();
  }

  @Override
  public PublisherDAO getPublisherDAO() {
    return new PublisherDAO();
  }
}
