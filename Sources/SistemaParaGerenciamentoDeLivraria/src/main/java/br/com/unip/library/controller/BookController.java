package br.com.unip.library.controller;

import br.com.unip.library.model.entity.Book;
import java.util.List;

public interface BookController {

  void create(Book book, List<Integer> authors);

  List<Book> listAll();

  void update(String existingBookIsbn, String title, Integer publisherId, Double price);

  void delete(String isbn);

}
