package br.com.unip.library.view;

import br.com.unip.library.service.publisher.PublisherServiceImpl;
import br.com.unip.library.util.LibraryUtils;

public class Application {

  public static void main(String[] args) {

    var publisherService = new PublisherServiceImpl();

    var randomString = "test";
    var maskedRandomString = LibraryUtils.maskString(randomString, 0, 4);



    System.out.println(randomString);
    System.out.println(maskedRandomString);

    publisherService.delete(12);


  }
}