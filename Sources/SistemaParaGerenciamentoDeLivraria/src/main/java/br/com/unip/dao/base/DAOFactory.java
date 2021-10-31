package br.com.unip.dao.base;

import br.com.unip.dao.AuthorDAO;
import br.com.unip.dao.BookAuthorDAO;
import br.com.unip.dao.BookDAO;
import br.com.unip.dao.PublisherDAO;
import java.lang.reflect.InvocationTargetException;

public abstract class DAOFactory {

  private static final Class FACTORY_CLASS = HibernateDAOFactory.class;

  public static DAOFactory getFactory() {
    try {
      return (DAOFactory) FACTORY_CLASS.getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      // TODO: personal exception.
      throw new RuntimeException();
    }
  }

  public abstract AuthorDAO getAuthorDAO();

  public abstract BookAuthorDAO getBookAuthorDAO();

  public abstract BookDAO getBookDAO();

  public abstract PublisherDAO getPublisherDAO();
}
