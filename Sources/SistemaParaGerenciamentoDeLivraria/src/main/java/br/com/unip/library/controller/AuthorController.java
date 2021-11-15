package br.com.unip.library.controller;

import br.com.unip.library.model.entity.Author;
import java.util.List;

public interface AuthorController {

  Author findById(Integer id);

  List<Author> findByNameThatContains(String name);

  List<Author> findByPseudonymThatContains(String pseudonym);

  void create(Author author);

  List<Author> listAll();

  void update(Integer id, String name, String fname);

  void delete(Integer id);
}
