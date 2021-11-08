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

  private BookDAO bookDAO = DAOFactory.getFactory().getBookDAO();
  private PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  @Override
  public void create(Book book) {
    if (Boolean.TRUE.equals(isValidNewBook(book))) {
      try {
        bookDAO.create(book);
        showInfo("Success", "Book successfully saved!");
      } catch (Exception exception) {
        throw new LibraryException("Error trying to save a new Book. " + exception.getMessage(),
            ExceptionErrorEnum.CREATE_BOOK);
      }
    }
  }

  @Override
  public List<Book> listAll() {
    try {
      return bookDAO.listAll();
    } catch (Exception exception) {
      throw new LibraryException("Error trying to list all Books. " + exception.getMessage(),
          ExceptionErrorEnum.LIST_BOOKS);
    }
  }

  @Override
  public Book findByIsbn(String isbn) {
    try {
      var book = bookDAO.findByIsbn(isbn);
      if (book == null) {
        throw new Exception("A book with this ISBN does not exists!");
      }
      return book;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to find a Book by ID. " + exception.getMessage(),
          ExceptionErrorEnum.FIND_BOOK_BY_ISBN);
    }
  }

  @Override
  public void update(String isbn, String title, Integer publisherId, Double price) {
    var stringBuilder = new StringBuilder();
    var book = findByIsbn(isbn);
    try {
      if (title != null && !title.isBlank() && !title.equals(book.getTitle())) {
        book.setTitle(title);
        stringBuilder.append("Book title has been updated!\n");
      }
      if (publisherId != null && publisherDAO.findById(publisherId) != null && !publisherId
          .equals(book.getPublisherId())) {
        book.setPublisherId(publisherId);
        stringBuilder.append("Book publisher has been updated!\n");
      }
      if (price != null && !price.equals(book.getPrice())) {
        book.setPrice(price);
        stringBuilder.append("Book price has been updated!\n");
      }
      var updatedFields = stringBuilder.toString();
      if (!updatedFields.isBlank()) {
        bookDAO.create(book);
        showInfo("Book Successfully Updated", updatedFields);
      } else {
        showInfo("The book has not been updated", "Invalid information to update the book.");
      }
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Update Book. " + exception.getMessage(),
          ExceptionErrorEnum.UPDATE_BOOK);
    }
  }

  @Override
  public void delete(String isbn) {
    var book = findByIsbn(isbn);
    try {
      bookDAO.delete(book);
      showInfo("Success", "Book with ISBN " + isbn + " has been deleted!");
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Delete Book. " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_BOOK);
    }
  }

  private Boolean isValidNewBook(Book book) {
    return new BookBO(book).toBook() != null;
  }
}
