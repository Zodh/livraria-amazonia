package br.com.unip.library.service.bookauthor;

public interface BookAuthorService {

  Boolean createBookAuthorByIsbn(String isbn, Integer authorId);

  void deleteBookAuthorByIsbn(String isbn);

  void deleteBookAuthorsByAuthorId(Integer id);

  Integer generateSeqNo();

}
