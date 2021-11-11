package br.com.unip.library.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static SessionFactory sessionFactory = new Configuration().configure()
      .buildSessionFactory();

  private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

  public static Session getSession() {
      if (threadLocal.get() == null){
        threadLocal.set(sessionFactory.openSession());
      }
      return threadLocal.get();
  }

  public static void beginTransaction() {
    getSession().beginTransaction();
  }

  public static void commitTransaction() {
    getSession().getTransaction().commit();
  }

  public static void rollBackTransaction() {
    getSession().getTransaction().rollback();
  }

  public static void closeSession() {
    getSession().close();
    threadLocal.set(null);
  }
}
