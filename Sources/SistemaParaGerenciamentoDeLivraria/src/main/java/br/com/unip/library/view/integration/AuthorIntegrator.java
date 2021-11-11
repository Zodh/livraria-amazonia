package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.AuthorControllerImpl;
import br.com.unip.library.model.entity.Author;

public class AuthorIntegrator {

  private static final AuthorControllerImpl authorController = new AuthorControllerImpl();

  public static void saveAuthor(String name, String fname) {
    var author = Author
        .builder()
        .name(name)
        .fname(fname)
        .build();
    authorController.create(author);
  }

}
