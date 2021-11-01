package br.com.unip.library.dao.base;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class BaseDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {

  private final Class<T> persistentClass;

  public BaseDAO(Class<T> persistentClass) {
    super();
    this.persistentClass = persistentClass;
  }

  @Override
  public void beginTransaction() {
    HibernateUtil.beginTransaction();
  }

  @Override
  public void commitTransaction() {
    HibernateUtil.commitTransaction();
  }

  @Override
  public void delete(T entity) {
    beginTransaction();
    HibernateUtil.getSession().delete(entity);
    commitTransaction();
    endTransaction();
  }

  @Override
  public void create(T entity) {
    beginTransaction();
    saveTransaction(entity);
    commitTransaction();
    endTransaction();
  }

  @Override
  public List<T> listAll() {
    beginTransaction();
    CriteriaQuery<T> criteriaQuery = HibernateUtil.getSession().getCriteriaBuilder()
        .createQuery(persistentClass);
    criteriaQuery.from(persistentClass);
    var list = HibernateUtil.getSession().createQuery(criteriaQuery).getResultList();
    endTransaction();
    return list;
  }

  @Override
  public void update(T entity){
    beginTransaction();
    HibernateUtil.getSession().update(entity);
    endTransaction();
  }

  protected void saveTransaction(T entity) {
    HibernateUtil.getSession().saveOrUpdate(entity);
  }

  protected void endTransaction() {
    HibernateUtil.closeSession();
  }
}
