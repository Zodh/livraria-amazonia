package br.com.unip.library.service.bookauthor;

import br.com.unip.library.dao.BookAuthorDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.BookAuthorBO;
import br.com.unip.library.model.entity.BookAuthor;
import java.util.Random;

public class BookAuthorServiceImpl implements BookAuthorService {

  private final BookAuthorDAO bookAuthorDAO = DAOFactory.getFactory().getBookAuthorDAO();

  @Override
  public Boolean createBookAuthorByIsbn(String isbn, Integer authorId) {
    try {
      var bookAuthor = buildValidBookAuthor(isbn, authorId);
      bookAuthorDAO.create(bookAuthor);
      return true;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to create a Book Author. " + exception.getMessage(),
          ExceptionErrorEnum.CREATE_BOOK_AUTHOR);
    }
  }

  @Override
  public Boolean deleteBookAuthorByIsbn(String isbn) {
    try {
      bookAuthorDAO.deleteByIsbn(isbn);
      return true;
    } catch (Exception exception) {
      throw new LibraryException(
          "Error trying to delete a Book Author by Book. " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_BOOK_AUTHOR_BY_ISBN);
    }
  }

  @Override
  public Boolean deleteBookAuthorsByAuthorId(Integer id) {
    try {
      bookAuthorDAO.deleteByAuthorId(id);
      return true;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to delete a Book Author by Author. " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_BOOK_AUTHOR_BY_AUTHOR_ID);
    }
  }

  private BookAuthor buildValidBookAuthor(String isbn, Integer authorId) {
    var bookAuthor = BookAuthor.builder().authorId(authorId).isbn(isbn).seqNo(generateSeqNo())
        .build();
    if (Boolean.TRUE.equals(isValidBookAuthor(bookAuthor))) {
      return bookAuthor;
    }
    throw new LibraryException("Error Trying to build a Book Author.",
        ExceptionErrorEnum.CREATE_BOOK_AUTHOR);
  }

  private Boolean isValidBookAuthor(BookAuthor bookAuthor) {
    return new BookAuthorBO(bookAuthor).toBookAuthor() != null;
  }

  @Override
  public Integer generateSeqNo() {
    return new Random().nextInt(99999);
  }
}
