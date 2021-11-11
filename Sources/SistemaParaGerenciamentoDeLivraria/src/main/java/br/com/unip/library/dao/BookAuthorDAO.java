package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.dao.base.HibernateUtil;
import br.com.unip.library.model.entity.BookAuthor;
import java.net.Proxy.Type;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Type> implements
    GenericDAO<BookAuthor, Type> {

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }

  public void deleteByIsbn(String isbn) {
    var criteriaBuilder = HibernateUtil.getSession().getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(BookAuthor.class);
    var root = criteriaQuery.from(BookAuthor.class);
    criteriaQuery.select(root).where(root.get("isbn").in(isbn));
    var query = HibernateUtil.getSession().createQuery(criteriaQuery);
    var result = query.getResultList();
    result.forEach(this::delete);
    commitTransaction();
    endTransaction();
  }

  public void deleteByAuthorId(Integer id) {
    var criteriaBuilder = HibernateUtil.getSession().getCriteriaBuilder();
    var criteriaQuery = criteriaBuilder.createQuery(BookAuthor.class);
    var root = criteriaQuery.from(BookAuthor.class);
    criteriaQuery.select(root).where(root.get("authorId").in(id));
    var query = HibernateUtil.getSession().createQuery(criteriaQuery);
    var result = query.getResultList();
    result.forEach(this::delete);
    commitTransaction();
    endTransaction();
  }
}
