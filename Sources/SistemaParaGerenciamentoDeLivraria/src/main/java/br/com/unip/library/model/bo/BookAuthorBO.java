package br.com.unip.library.model.bo;

import br.com.unip.library.dao.AuthorDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Book;
import br.com.unip.library.model.entity.BookAuthor;

public class BookAuthorBO {

  private final String isbn;

  private final Integer authorId;

  private final Integer seqNo;

  private AuthorDAO authorDAO = DAOFactory.getFactory().getAuthorDAO();

  public BookAuthorBO(BookAuthor bookAuthor) {
    this.isbn = bookAuthor.getIsbn();
    this.authorId = bookAuthor.getAuthorId();
    this.seqNo = bookAuthor.getSeqNo();
    checkIfAuthorIdIsValid();
    checkIfIsbnIsValid();
  }

  private void checkIfIsbnIsValid() {
    var message = "";
    Book book;
    if (this.isbn == null || this.isbn.isBlank()) {
      message = "ISBN is null, empty or just whitespaces!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_BOOK_AUTHOR_BO);
    }
  }

  private void checkIfAuthorIdIsValid(){
    var author = authorDAO.findById(authorId);
    var message = "";
    if (author == null){
      message = "An Author with this ID does not exists!";
    }
    if (!message.equals("")){
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_BOOK_AUTHOR_BO);
    }
  }

  public BookAuthor toBookAuthor() {
    return BookAuthor
        .builder()
        .isbn(isbn)
        .authorId(authorId)
        .seqNo(seqNo)
        .build();
  }
}
