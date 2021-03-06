package br.com.unip.library.dao.base;

import br.com.unip.library.dao.AuthorDAO;
import br.com.unip.library.dao.BookAuthorDAO;
import br.com.unip.library.dao.BookDAO;
import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import java.lang.reflect.InvocationTargetException;

public abstract class DAOFactory {

  private static final Class FACTORY_CLASS = HibernateDAOFactory.class;

  public static DAOFactory getFactory() {
    try {
      return (DAOFactory) FACTORY_CLASS.getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new LibraryException("Error trying to create DAO.", ExceptionErrorEnum.CREATE_DAO);
    }
  }

  public abstract AuthorDAO getAuthorDAO();

  public abstract BookAuthorDAO getBookAuthorDAO();

  public abstract BookDAO getBookDAO();

  public abstract PublisherDAO getPublisherDAO();
}
