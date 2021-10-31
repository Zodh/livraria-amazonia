package br.com.unip.dao.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Type extends Serializable> {

  void beginTransaction();

  void create(T entity);

  void delete(T entity);

  void commitTransaction();

  List<T> listAll();

}
