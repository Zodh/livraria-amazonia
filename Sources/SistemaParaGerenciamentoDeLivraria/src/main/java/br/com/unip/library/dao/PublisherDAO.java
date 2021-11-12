package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Publisher;

public class PublisherDAO extends BaseDAO<Publisher, Integer> implements
    GenericDAO<Publisher, Integer> {

  public PublisherDAO() {
    super(Publisher.class);
  }

  public Publisher findById(Integer id) throws Exception {
    try {
      beginTransaction();
      var session = HibernateUtil.getSession();
      var publisher = session.get(Publisher.class, id);
      commitTransaction();
      return publisher;
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to find a Publisher by id.");
    } finally {
      endTransaction();
    }

  }
}
