package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.BookControllerImpl;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookIntegrator {

  private static BookControllerImpl bookController = new BookControllerImpl();

  public static List<Integer> fromAuthorsStringToList(String string) {
    var list = new ArrayList<Integer>();
    var authorsVector = string.split(",");
    try {
      for (String value : authorsVector) {
        list.add(Integer.parseInt(value));
      }
    } catch (Exception exception) {
      throw new LibraryException(
          "Invalid Author(s) input. " + exception.getMessage(),
          ExceptionErrorEnum.INVALID_INPUT_NBCM);
    }
    return list;
  }

  public static void saveBook(String title, String isbn, Integer publisher, Double price, List<Integer> authors){
    var book = Book
        .builder()
        .title(title)
        .isbn(isbn)
        .publisherId(publisher)
        .price(price)
        .build();
    bookController.create(book, authors);
  }

}
