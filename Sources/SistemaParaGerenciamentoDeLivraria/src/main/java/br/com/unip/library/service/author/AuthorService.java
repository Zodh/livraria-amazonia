package br.com.unip.library.service.author;

import br.com.unip.library.model.entity.Author;
import java.util.List;

public interface AuthorService {

  void create(Author author);

  List<Author> listAll();

  List<Author> findByNameThatContains(String name);

  List<Author> findByPseudonymThatContains(String pseudonym);

  Author findById(Integer id);

  void update(Integer id, String name, String fname);

  void delete(Integer id);
}
