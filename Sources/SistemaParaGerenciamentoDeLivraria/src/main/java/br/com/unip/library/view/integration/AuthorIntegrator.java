package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.AuthorControllerImpl;
import br.com.unip.library.model.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorIntegrator {

  private static final Logger log = LoggerFactory.getLogger(AuthorIntegrator.class);

  private static final AuthorControllerImpl authorController = new AuthorControllerImpl();

  public static void saveAuthor(String name, String fname) {
    log.info("Starting the flow to register an author.");
    var author = Author
        .builder()
        .name(name)
        .fname(fname)
        .build();
    authorController.create(author);
    log.info("Finishing the flow to register an author.");
  }

}
