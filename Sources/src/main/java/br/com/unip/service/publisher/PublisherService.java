package br.com.unip.service.publisher;

import br.com.unip.model.dto.PublisherDTO;
import java.util.List;

public interface PublisherService {

  PublisherDTO create(String name, String url);

  List<PublisherDTO> list();

  PublisherDTO update(PublisherDTO publisherDTO);

  void deleteById(Integer publisherId);
}
