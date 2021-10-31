package br.com.unip.dao;

import br.com.unip.dao.base.BaseDAO;
import br.com.unip.dao.base.GenericDAO;
import br.com.unip.dao.base.HibernateUtil;
import br.com.unip.model.entity.Publisher;

public class PublisherDAO extends BaseDAO<Publisher, Integer> implements
    GenericDAO<Publisher, Integer> {

  public PublisherDAO() {
    super(Publisher.class);
  }

  public Publisher findById(Integer id){
    beginTransaction();
    var session = HibernateUtil.getSession();
    var publisher = session.get(Publisher.class, id);
    endTransaction();
    return publisher;
  }
}
