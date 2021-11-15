package br.com.unip.library.service.bookauthor;

import br.com.unip.library.dao.BookAuthorDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.BookAuthorBO;
import br.com.unip.library.model.entity.BookAuthor;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAuthorServiceImpl implements BookAuthorService {

  private static final Logger log = LoggerFactory.getLogger(BookAuthorServiceImpl.class);

  private final BookAuthorDAO bookAuthorDAO = DAOFactory.getFactory().getBookAuthorDAO();

  @Override
  public Boolean createBookAuthorByIsbn(String isbn, Integer authorId) {
    try {
      log.info("Building a valid book author");
      var bookAuthor = buildValidBookAuthor(isbn, authorId);
      bookAuthorDAO.create(bookAuthor);
      return true;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to create a Book Author. " + exception.getMessage(),
          ExceptionErrorEnum.CREATE_BOOK_AUTHOR);
    }
  }

  private BookAuthor buildValidBookAuthor(String isbn, Integer authorId) throws Exception {
    var bookAuthor = BookAuthor.builder().authorId(authorId).isbn(isbn).seqNo(generateSeqNo())
        .build();
    try {
      if (Boolean.TRUE.equals(isValidBookAuthor(bookAuthor))) {
        return bookAuthor;
      }
      return null;
    } catch (Exception exception) {
      throw new Exception("Error Trying to build a Book Author.");
    }
  }

  private Boolean isValidBookAuthor(BookAuthor bookAuthor) throws Exception {
    return new BookAuthorBO(bookAuthor).toBookAuthor() != null;
  }

  @Override
  public Integer generateSeqNo() {
    return new Random().nextInt(99999);
  }
}
