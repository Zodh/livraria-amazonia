package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.Publisher;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherDAO extends BaseDAO<Publisher, Integer> implements
    GenericDAO<Publisher, Integer> {

  private static final Logger log = LoggerFactory.getLogger(PublisherDAO.class);

  public PublisherDAO() {
    super(Publisher.class);
  }

  public void create(Publisher publisher) throws Exception {
    openConn();
    var sql = "insert into publishers (name, url) values (?,?)";
    try {
      var statement = connection.prepareStatement(sql);
      statement.setString(1, publisher.getName());
      statement.setString(2, publisher.getUrl());
      log.info("Inserting data into the Publishers table");
      statement.execute();
      statement.close();
    } catch (Exception exception) {
      throw new Exception(
          "Error trying to save a new Publisher in the database. " + exception.getMessage());
    } finally {
      log.info("Ending connection");
      closeConn();
    }
  }

  public List<Publisher> findByNameThatContains(String name) {
    beginTransaction();
    var criteriaBuilder = HibernateUtil.getSession().getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(Publisher.class);
    var root = criteriaQuery.from(Publisher.class);
    criteriaQuery.select(root).where(
        criteriaBuilder.like(
            root.get("name"), "%" + name + "%"
        ));
    var query = HibernateUtil.getSession().createQuery(criteriaQuery);
    var result = query.getResultList();
    endTransaction();
    return result;
  }

  public void deleteById(Integer id) throws Exception {
    try {
      log.info("Starting database connection");
      beginTransaction();
      log.info("Deleting entity in the database");
      var publisherQuery = "delete Publisher p where p.publisherId = :id";
      HibernateUtil.getSession()
          .createQuery(publisherQuery)
          .setParameter("id", id)
          .executeUpdate();
      commitTransaction();
    } catch (Exception exception) {
      rollbackTransaction();
      throw new Exception("Error trying to delete a Publisher." + exception.getMessage());
    } finally {
      log.info("Closing connection to database");
      endTransaction();
    }
  }

  public Publisher findById(Integer id) {
    beginTransaction();
    var session = HibernateUtil.getSession();
    var publisher = session.get(Publisher.class, id);
    endTransaction();
    return publisher;
  }
}
