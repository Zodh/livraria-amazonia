package br.com.unip.library.service.publisher;


import br.com.unip.library.model.entity.Publisher;
import java.util.List;

public interface PublisherService {

  void create(String name, String url);

  List<Publisher> listAll();

  Publisher findById(Integer id);

  void update(Publisher publisherDTO);

  void delete(Integer publisherId);
}
