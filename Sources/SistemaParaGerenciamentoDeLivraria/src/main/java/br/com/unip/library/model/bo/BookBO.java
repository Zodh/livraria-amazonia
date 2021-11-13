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

  private final String title;
  private final String isbn;
  private final Integer publisherId;
  private final Double price;

  BookDAO bookDAO = DAOFactory.getFactory().getBookDAO();
  PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  public BookBO(Book book) {
    this.title = book.getTitle();
    this.isbn = book.getIsbn();
    this.publisherId = book.getPublisherId();
    this.price = book.getPrice();
    checkIfTitleIsValid();
    checkIfIsbnIsValid();
    checkIfPublisherIsValid();
  }

  public Book toBook() {
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
    if (this.title == null || this.title.isBlank()) {
      message = "Book title is null, empty or just whitespaces!";
    }
    if (this.title != null && this.title.length() > 60) {
      message = "Book title cannot be greater than 60!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_BOOK_BO);
    }
  }

  private void checkIfIsbnIsValid() {
    var message = "";
    Book book;
    if (this.isbn == null || this.isbn.isBlank()) {
      message = "ISBN is null, empty or just whitespaces!";
    } else {
      book = bookDAO.findByIsbn(this.isbn);
      if (book != null) {
        message = "A book with this ISBN already exists!";
      }
    }
    if (this.isbn != null && isbn.length() != 13) {
      message = "Invalid ISBN length!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_BOOK_BO);
    }
  }

  private void checkIfPublisherIsValid() {
    var message = "";
    var publisher = publisherDAO.findById(this.publisherId);
    if (publisher == null) {
      message = "A publisher with this ID does not exists!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_BOOK_BO);
    }
  }
}
