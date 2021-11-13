package br.com.unip.library.dao.base;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {

  private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);

  private final Class<T> persistentClass;

  public BaseDAO(Class<T> persistentClass) {
    super();
    this.persistentClass = persistentClass;
  }

  @Override
  public void delete(T entity) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info("Deleting entity in the database");
      HibernateUtil.getSession().delete(entity);
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to delete an object.");
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  @Override
  public void create(T entity) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info(String.format("Registering entity (%s) in the database", entity.getClass()));
      saveTransaction(entity);
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to create an object.");
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  @Override
  public List<T> listAll() throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      CriteriaQuery<T> criteriaQuery = HibernateUtil.getSession().getCriteriaBuilder()
          .createQuery(persistentClass);
      criteriaQuery.from(persistentClass);
      log.info(String.format("Listing all entities (%s) in the database", this.getClass()));
      var list = HibernateUtil.getSession().createQuery(criteriaQuery).getResultList();
      return list;
    } catch (Exception exception) {
      throw new Exception("Error trying to list objects");
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  @Override
  public void update(T entity) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info(String.format("Updating entity (%s) in the database", entity.getClass()));
      HibernateUtil.getSession().update(entity);
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to update fields.");
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  protected void saveTransaction(T entity) {
    HibernateUtil.getSession().save(entity);
  }

  public void beginTransaction() {
    HibernateUtil.beginTransaction();
  }

  public void rollbackTransaction() {
    HibernateUtil.rollBackTransaction();
  }

  public void commitTransaction() {
    HibernateUtil.commitTransaction();
  }

  protected void endTransaction() {
    HibernateUtil.closeSession();
  }
}
