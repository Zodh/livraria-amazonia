package br.com.unip.library.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

  private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
  private static SessionFactory sessionFactory = new Configuration().configure()
      .buildSessionFactory();

  public static Session getSession() {
    if (threadLocal.get() == null) {
      threadLocal.set(sessionFactory.openSession());
    }
    return threadLocal.get();
  }

  public static void beginTransaction() {
    getSession().beginTransaction();
    if (!getSession().getTransaction().isActive()){
      getSession().beginTransaction();
    }

  }

  public static void commitTransaction() {
    try{
      getSession().getTransaction().commit();
    } catch (Exception exception){
      getSession().flush();
      getSession().clear();
      getSession().getTransaction().commit();
    }
  }

  public static void rollBackTransaction() {
    getSession().getTransaction().rollback();
  }

  public static void closeSession() {
    threadLocal.remove();
  }
}
