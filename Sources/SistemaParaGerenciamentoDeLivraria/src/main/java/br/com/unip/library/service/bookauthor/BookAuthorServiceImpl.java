package br.com.unip.library.service.bookauthor;

import br.com.unip.library.dao.BookAuthorDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.BookAuthorBO;
import br.com.unip.library.model.entity.BookAuthor;
import java.util.Random;

public class BookAuthorServiceImpl implements BookAuthorService {

  private BookAuthorDAO bookAuthorDAO = DAOFactory.getFactory().getBookAuthorDAO();

  @Override
  public Boolean createBookAuthorByIsbn(String isbn, Integer authorId) {
    try {
      var bookAuthor = buildValidBookAuthor(isbn, authorId);
      bookAuthorDAO.create(bookAuthor);
      return true;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to create a Book Author.",
          ExceptionErrorEnum.CREATE_BOOK_AUTHOR);
    }
  }

  @Override
  public void deleteBookAuthorByIsbn(String isbn) {

  }

  @Override
  public void deleteBookAuthorsByAuthorId(Integer id) {

  }

  private BookAuthor buildValidBookAuthor(String isbn, Integer authorId) {
    var seqNo = generateSeqNo();
    var bookAuthor = BookAuthor.builder().authorId(authorId).isbn(isbn).seqNo(seqNo).build();
    if (isValidBookAuthor(bookAuthor, seqNo)) {
      return bookAuthor;
    }
    throw new LibraryException("Error Trying to build a Book Author.",
        ExceptionErrorEnum.CREATE_BOOK_AUTHOR);
  }

  private Boolean isValidBookAuthor(BookAuthor bookAuthor, Integer seqNo) {
    return new BookAuthorBO(bookAuthor, seqNo).toBookAuthor() != null;
  }

  @Override
  public Integer generateSeqNo() {
    return new Random().nextInt(99999);
  }
}
