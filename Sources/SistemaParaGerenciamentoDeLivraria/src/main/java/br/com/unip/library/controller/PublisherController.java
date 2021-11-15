package br.com.unip.library.controller;

import br.com.unip.library.model.entity.Publisher;
import java.util.List;

public interface PublisherController {

  void create(Publisher publisher);

  List<Publisher> listAll();

  List<Publisher> findByNameThatContains(String name);

  Publisher findById(Integer id);

  void update(Integer id, String name, String url);

  void delete(Integer id);
}
