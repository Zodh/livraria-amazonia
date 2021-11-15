package br.com.unip.library.controller.impl;

import br.com.unip.library.controller.BookController;
import br.com.unip.library.model.entity.Book;
import br.com.unip.library.service.book.BookServiceImpl;
import java.util.List;

public class BookControllerImpl implements BookController {

  private final BookServiceImpl bookService = new BookServiceImpl();

  @Override
  public void create(Book book, List<Integer> authors) {
    bookService.create(book, authors);
  }

  @Override
  public List<Book> listAll() {
    return bookService.listAll();
  }

  @Override
  public void update(String existingBookIsbn, String title, Integer publisherId, Double price) {
    bookService.update(existingBookIsbn, title, publisherId, price);
  }

  @Override
  public void delete(String isbn) {
    bookService.delete(isbn);
  }

  @Override
  public Book findByIsbn(String isbn) {
    return bookService.findByIsbn(isbn);
  }

  @Override
  public List<Book> findByPublisherId(Integer publisherId) {
    return bookService.findByPublisherId(publisherId);
  }

  @Override
  public List<Book> findByTitleThatContains(String title) {
    return bookService.findByTitleThatContains(title);
  }
}
