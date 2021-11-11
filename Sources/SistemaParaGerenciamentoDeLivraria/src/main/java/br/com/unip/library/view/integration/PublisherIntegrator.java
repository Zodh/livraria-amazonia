package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.PublisherControllerImpl;
import br.com.unip.library.model.entity.Publisher;

public class PublisherIntegrator {

  private static final PublisherControllerImpl publisherController = new PublisherControllerImpl();

  public static void savePublisher(String name, String url) {
    var publisher = Publisher
        .builder()
        .name(name)
        .url(url)
        .build();

    publisherController.create(publisher);
  }

}
