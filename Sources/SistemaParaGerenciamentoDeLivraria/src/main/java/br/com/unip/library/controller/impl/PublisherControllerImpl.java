package br.com.unip.library.controller.impl;

import br.com.unip.library.controller.PublisherController;
import br.com.unip.library.model.entity.Publisher;
import br.com.unip.library.service.publisher.PublisherServiceImpl;
import java.util.List;

public class PublisherControllerImpl implements PublisherController {

  private final PublisherServiceImpl publisherService = new PublisherServiceImpl();

  @Override
  public void create(Publisher publisher) {
    publisherService.create(publisher);
  }

  @Override
  public List<Publisher> listAll() {
    return publisherService.listAll();
  }

  @Override
  public List<Publisher> findByNameThatContains(String name) {
    return publisherService.findByNameThatContains(name);
  }

  @Override
  public Publisher findById(Integer id) {
    return publisherService.findById(id);
  }

  @Override
  public void update(Integer id, String name, String url) {
    publisherService.update(id, name, url);
  }

  @Override
  public void delete(Integer id) {
    publisherService.delete(id);
  }
}
