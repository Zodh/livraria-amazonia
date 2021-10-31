package br.com.unip.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static final SessionFactory sessionFactory = new Configuration().configure()
      .buildSessionFactory();

  private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

  public static Session getSession() {
    var session = threadLocal.get();
    if (session == null) {
      session = sessionFactory.openSession();
      threadLocal.set(session);
    }
    return session;
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
    threadLocal.remove();
  }
}
