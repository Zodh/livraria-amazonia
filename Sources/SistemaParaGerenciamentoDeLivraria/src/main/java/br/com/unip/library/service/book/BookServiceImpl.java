package br.com.unip.library.service.book;

import static br.com.unip.library.util.LibraryUtils.showInfo;

import br.com.unip.library.dao.BookDAO;
import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.BookBO;
import br.com.unip.library.model.entity.Book;
import java.util.List;
import lombok.extern.java.Log;

@Log
public class BookServiceImpl implements BookService {

  BookDAO bookDAO = DAOFactory.getFactory().getBookDAO();
  PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  @Override
  public void create(Book book) {
    if (Boolean.TRUE.equals(isValidNewBook(book))) {
      try {
        bookDAO.create(book);
        showInfo("Success", "Book successfully saved!");
      } catch (Exception exception) {
        throw LibraryException
            .builder()
            .message("Error trying to save a new Book. " + exception.getMessage())
            .action(ExceptionErrorEnum.CREATE_BOOK)
            .build();
      }
    }
  }

  @Override
  public List<Book> listAll() {
    try {
      return bookDAO.listAll();
    } catch (Exception exception) {
      throw LibraryException
          .builder()
          .message("Error trying to list all Books. " + exception.getMessage())
          .action(ExceptionErrorEnum.LIST_BOOKS)
          .build();
    }
  }

  @Override
  public Book findById(String isbn) {
    try {
      var book = bookDAO.findById(isbn);
      if (book == null) {
        throw new Exception("A book with this ISBN does not exists!");
      }
      return book;
    } catch (Exception exception) {
      throw LibraryException
          .builder()
          .message("Error trying to find a Book by ID. " + exception.getMessage())
          .action(ExceptionErrorEnum.FIND_BOOK_BY_ID)
          .build();
    }
  }

  @Override
  public void update(String isbn, String title, Integer publisherId, Double price) {
    var stringBuilder = new StringBuilder();
    var book = findById(isbn);
    try {
      if (title != null && !title.isBlank() && !title.equals(book.getTitle())) {
        book.setTitle(title);
        stringBuilder.append("Book title has been updated!\n");
      } else {
        stringBuilder.append("Book title has NOT been updated!\n");
      }
      if (publisherId != null && publisherDAO.findById(publisherId) != null && !publisherId
          .equals(book.getPublisherId())) {
        book.setPublisherId(publisherId);
        stringBuilder.append("Book publisher has been updated!\n");
      } else {
        stringBuilder.append("Book publisher has NOT been updated!\n");
      }
      if (price != null && !price.equals(book.getPrice())) {
        book.setPrice(price);
        stringBuilder.append("Book price has been updated!\n");
      } else {
        stringBuilder.append("Book price has NOT been updated!\n");
      }
      var updatedFields = stringBuilder.toString();
      if (!updatedFields.isBlank()) {
        bookDAO.create(book);
        showInfo("Book Successfuly Updated", updatedFields);
      }
    } catch (Exception exception) {
      throw LibraryException
          .builder()
          .action(ExceptionErrorEnum.UPDATE_BOOK)
          .message("Error Trying to Update Book. " + exception.getMessage())
          .build();
    }
  }

  @Override
  public void delete(String isbn) {
    var book = findById(isbn);
    try{
      bookDAO.delete(book);
      showInfo("Success", "Book with ISBN " + isbn + " has been deleted!");
    } catch (Exception exception){
      throw LibraryException
          .builder()
          .action(ExceptionErrorEnum.DELETE_BOOK)
          .message("Error Trying to Delete Book. " + exception.getMessage())
          .build();
    }
  }

  private Boolean isValidNewBook(Book book) {
    return new BookBO(book).toBook() != null;
  }
}
