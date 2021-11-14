package br.com.unip.library.dao.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Type extends Serializable> {

  void update(T entity) throws Exception;

  void delete(T entity) throws Exception;

  List<T> listAll() throws Exception;
}
