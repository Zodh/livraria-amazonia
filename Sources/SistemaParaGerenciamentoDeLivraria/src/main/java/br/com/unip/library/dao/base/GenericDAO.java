package br.com.unip.library.dao.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Type extends Serializable> {

  void create(T entity);

  void update(T entity);

  void delete(T entity);

  List<T> listAll();
}
