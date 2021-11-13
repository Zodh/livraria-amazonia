package br.com.unip.library.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
  private static SessionFactory sessionFactory = new Configuration().configure()
      .buildSessionFactory();

  public static Session getSession() {
    if (sessionFactory.isClosed()) {
      sessionFactory.openSession();
    }
    if (threadLocal.get() == null) {
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
    threadLocal.remove();
  }
}
