package br.com.unip.library.service.book;

import br.com.unip.library.model.entity.Book;
import java.util.List;

public interface BookService {

  void create(Book book, List<Integer> authors);

  List<Book> listAll();

  Book findByIsbn(String isbn);

  void update(String existingBookIsbn, String title, Integer publisherId, Double price);

  void delete(String isbn);

  List<Book> findByPublisherId(Integer publisherId);

  List<Book> findByTitleThatContains(String title);
}
