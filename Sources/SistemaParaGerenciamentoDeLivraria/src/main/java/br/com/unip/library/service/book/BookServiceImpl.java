package br.com.unip.library.service.book;

import static br.com.unip.library.util.LibraryUtils.showInfo;

import br.com.unip.library.dao.BookDAO;
import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.BookBO;
import br.com.unip.library.model.entity.Book;
import br.com.unip.library.service.bookauthor.BookAuthorServiceImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookServiceImpl implements BookService {

  private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

  private final BookDAO bookDAO = DAOFactory.getFactory().getBookDAO();
  private final PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();
  private final BookAuthorServiceImpl bookAuthorService = new BookAuthorServiceImpl();

  @Override
  public void create(Book book, List<Integer> authors) {
    try {
      if (Boolean.TRUE.equals(isValidNewBook(book))) {
        bookDAO.create(book);
        authors.forEach(author -> bookAuthorService.createBookAuthorByIsbn(book.getIsbn(), author));
        showInfo("Success", String
            .format("Book successfully saved!%nISBN: %s%nTitle: %s%nPrice: %.2f", book.getIsbn(),
                book.getTitle(), book.getPrice()));
      }
    } catch (Exception exception) {
      throw new LibraryException("Ooops... Error trying to save a new Book. Try again.\nMessage: " + exception.getMessage(),
          ExceptionErrorEnum.CREATE_BOOK);
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
  public List<Book> findByPublisherId(Integer publisherId){
    try{
      return bookDAO.findByPublisherId(publisherId);
    } catch (Exception exception){
      throw new LibraryException("Error trying to list Books by Publisher Id. " + exception.getMessage(), ExceptionErrorEnum.FIND_BOOK_BY_PUBLISHER_ID);
    }
  }

  @Override
  public List<Book> findByTitleThatContains(String title) {
    try{
      return bookDAO.findByTitleThatContains(title);
    } catch (Exception exception){
      throw new LibraryException("Error trying to list Books by Title", ExceptionErrorEnum.FIND_BOOK_BY_TITLE);
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
      if (publisherId != null && publisherDAO.findById(publisherId) != null) {
        book.setPublisherId(publisherId);
        stringBuilder.append("Book publisher has been updated!\n");
      }
      if (price != null && !price.equals(book.getPrice())) {
        book.setPrice(price);
        stringBuilder.append("Book price has been updated!\n");
      }
      var updatedFields = stringBuilder.toString();
      if (!updatedFields.isBlank()) {
        bookDAO.update(book);
        showInfo("Book Successfully Updated", updatedFields);
      } else {
        showInfo("The book has not been updated", "Invalid information to update the book.");
      }
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Update Book. Try again.\nMessage: " + exception.getMessage(),
          ExceptionErrorEnum.UPDATE_BOOK);
    }
  }

  @Override
  public void delete(String isbn) {
    try {
      bookDAO.deleteBookAndBatchDeleteBookAuthors(isbn);
      showInfo("Success", "Book with ISBN " + isbn + " has been deleted!");
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Delete Book. Try again.\nMessage: " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_BOOK);
    }
  }

  private Boolean isValidNewBook(Book book) {
    log.info("Checking if the data informed to register a book is valid.");
    return new BookBO(book).toBook() != null;
  }
}
