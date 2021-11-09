package br.com.unip.library.service.bookauthor;

public interface BookAuthorService {

  Boolean createBookAuthorByIsbn(String isbn, Integer authorId);

  Boolean deleteBookAuthorByIsbn(String isbn);

  Boolean deleteBookAuthorsByAuthorId(Integer id);

  Integer generateSeqNo();

}
