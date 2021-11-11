package br.com.unip.library.controller.impl;

import br.com.unip.library.controller.AuthorController;
import br.com.unip.library.model.entity.Author;
import br.com.unip.library.service.author.AuthorServiceImpl;
import java.util.List;

public class AuthorControllerImpl implements AuthorController {

  private final AuthorServiceImpl authorService = new AuthorServiceImpl();

  @Override
  public void create(Author author) {
    authorService.create(author);
  }

  @Override
  public List<Author> listAll() {
    return authorService.listAll();
  }

  @Override
  public void update(Integer id, String name, String fname) {
    authorService.update(id, name, fname);
  }

  @Override
  public void delete(Integer id) {
    authorService.delete(id);
  }
}
