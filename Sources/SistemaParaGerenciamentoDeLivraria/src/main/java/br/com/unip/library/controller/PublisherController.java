package br.com.unip.library.controller;

import br.com.unip.library.model.entity.Publisher;
import java.util.List;

public interface PublisherController {

  void create(String name, String url);

  List<Publisher> listAll();

  void update(Integer id, String name, String url);

  void delete(Integer id);
}
