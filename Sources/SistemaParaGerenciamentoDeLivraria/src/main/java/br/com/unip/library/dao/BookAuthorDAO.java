package br.com.unip.library.dao;

import br.com.unip.library.dao.base.BaseDAO;
import br.com.unip.library.dao.base.GenericDAO;
import br.com.unip.library.model.entity.BookAuthor;
import java.net.Proxy.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAuthorDAO extends BaseDAO<BookAuthor, Type> implements
    GenericDAO<BookAuthor, Type> {

  private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);

  public BookAuthorDAO() {
    super(BookAuthor.class);
  }
}
