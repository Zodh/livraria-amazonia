package br.com.unip.library.model.bo;

import br.com.unip.library.dao.BookDAO;
import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Book;
import lombok.Getter;

@Getter
public class BookBO {

  BookDAO bookDAO = DAOFactory.getFactory().getBookDAO();
  PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  private final String title;

  private final String isbn;

  private final Integer publisherId;

  private final Double price;

  public BookBO(String title, String isbn, Integer publisherId, Double price) {
    this.title = title;
    this.isbn = isbn;
    this.publisherId = publisherId;
    this.price = price;
    checkIfTitleIsValid();
    checkIfIsbnIsValid();
    checkIfPublisherIsValid();
  }

  public Book build() {
    return Book
        .builder()
        .title(title)
        .isbn(isbn)
        .publisherId(publisherId)
        .price(price)
        .build();
  }

  private void checkIfTitleIsValid() {
    var message = "";
    if (this.title.isBlank()) {
      message = "Title is null or empty; ";
    }
    if (!message.equals("")) {
      throw LibraryException
          .builder()
          .action(ExceptionErrorEnum.CREATE_BOOK)
          .message(message)
          .build();
    }
  }

  private void checkIfIsbnIsValid() {
    var message = "";
    Book book;
    if (this.isbn.isBlank()) {
      message = "ISBN is null or empty; ";
    } else {
      book = bookDAO.findById(this.isbn);
      if (book != null) {
        message = "A book with this ISBN already exists!";
      }
    }
    if (!message.equals("")) {
      throw LibraryException
          .builder()
          .action(ExceptionErrorEnum.CREATE_BOOK)
          .message(message)
          .build();
    }
  }

  private void checkIfPublisherIsValid() {
    var message = "";
    var publisher = publisherDAO.findById(this.publisherId);
    if (publisher == null) {
      message = "A publisher with this ID does not exists!";
    }
    if (!message.equals("")) {
      throw LibraryException
          .builder()
          .action(ExceptionErrorEnum.CREATE_BOOK)
          .message(message)
          .build();
    }
  }
}
