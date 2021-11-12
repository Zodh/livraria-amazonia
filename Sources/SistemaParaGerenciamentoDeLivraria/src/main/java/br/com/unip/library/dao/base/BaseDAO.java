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
  public void delete(T entity) {
    log.info("Starting database connection");
    beginTransaction();
    log.info("Deleting entity in the database");
    HibernateUtil.getSession().delete(entity);
    commitTransaction();
    log.info("Closing connection to database");
    endTransaction();
  }

  @Override
  public void create(T entity) {
    log.info("Starting database connection");
    beginTransaction();
    log.info(String.format("Registering entity (%s) in the database", entity.getClass()));
    saveTransaction(entity);
    commitTransaction();
    log.info("Closing connection to database");
    endTransaction();
  }

  @Override
  public List<T> listAll() {
    log.info("Starting database connection");
    beginTransaction();
    CriteriaQuery<T> criteriaQuery = HibernateUtil.getSession().getCriteriaBuilder()
        .createQuery(persistentClass);
    criteriaQuery.from(persistentClass);
    log.info(String.format("Listing all entities (%s) in the database", this.getClass()));
    var list = HibernateUtil.getSession().createQuery(criteriaQuery).getResultList();
    log.info("Closing connection to database");
    endTransaction();
    return list;
  }

  @Override
  public void update(T entity) {
    log.info("Starting database connection");
    beginTransaction();
    log.info("Updating entity in the database");
    HibernateUtil.getSession().update(entity);
    log.info("Closing connection to database");
    endTransaction();
  }

  protected void saveTransaction(T entity) {
    HibernateUtil.getSession().saveOrUpdate(entity);
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
