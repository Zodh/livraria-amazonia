package br.com.unip.library.service.bookauthor;

public interface BookAuthorService {

  Boolean createBookAuthorByIsbn(String isbn, Integer authorId);

  Integer generateSeqNo();

}
