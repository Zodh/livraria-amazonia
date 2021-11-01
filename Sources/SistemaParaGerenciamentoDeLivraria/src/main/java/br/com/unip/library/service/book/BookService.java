package br.com.unip.library.service.book;

import br.com.unip.library.model.entity.Book;
import java.util.List;

public interface BookService {

  void create(Book book);

  List<Book> listAll();

  Book findById(String isbn);

  void update(String existingBookIsbn, String title, Integer publisherId, Double price);

  void delete(String isbn);



}
