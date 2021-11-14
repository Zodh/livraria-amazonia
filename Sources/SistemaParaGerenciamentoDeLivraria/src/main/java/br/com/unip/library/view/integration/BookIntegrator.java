package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.BookControllerImpl;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Book;
import br.com.unip.library.util.LibraryUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookIntegrator {

  private static final Logger log = LoggerFactory.getLogger(BookIntegrator.class);

  private static final BookControllerImpl bookController = new BookControllerImpl();

  public static final DefaultTableModel findByIsbn(String isbn){
    log.info(String.format("Starting the flow to list Book by ISBN"));
    var book = bookController.findByIsbn(isbn);
    String[] column = {"ISBN", "Title", "Publisher", "Price"};
    var tableModel = new DefaultTableModel(column, 0);
    Object[] row = {book.getIsbn(), book.getTitle(), book.getPublisherId(), book.getPrice()};
    tableModel.addRow(row);
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Book by ISBN"));
    return tableModel;
  }

  public static DefaultTableModel fromBookListedByTitleToTableModel(String title){
    log.info(String.format("Starting the flow to list Books by title that contains (%s)", title));
    var bookList = bookController.findByTitleThatContains(title);
    String[] column = {"ISBN", "Title", "Publisher", "Price"};
    var tableModel = new DefaultTableModel(column, 0);

    bookList.forEach(item -> {
      Object[] row = {item.getIsbn(), item.getTitle(), item.getPublisherId(), item.getPrice()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Books by title that contains (%s)", title));
    return tableModel;
  }

  public static DefaultTableModel fromBookListedByPublisherIdToTableModel(Integer id){
    log.info(String.format("Starting the flow to list Books by Publisher ID that contains (%s)", id));
    var bookList = bookController.findByPublisherId(id);
    String[] column = {"ISBN", "Title", "Publisher", "Price"};
    var tableModel = new DefaultTableModel(column, 0);

    bookList.forEach(item -> {
      Object[] row = {item.getIsbn(), item.getTitle(), item.getPublisherId(), item.getPrice()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Books by Publisher ID that contains (%s)", id));
    return tableModel;
  }

  public static void deleteBookByIsbn(String isbn) {
    log.info(String.format("Starting the flow to delete a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
    LibraryUtils.isOnlyNumbers(isbn);
    bookController.delete(isbn);
    log.info(String.format("Finishing the flow to delete a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
  }

  public static void updateBookFields(String isbn, String title, Integer publisher, Double price) {
    log.info(String.format("Starting the flow to update a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
    bookController.update(isbn, title, publisher, price);
    log.info(String.format("Finishing the flow to update a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
  }

  public static List<Integer> fromAuthorsStringToList(String string) {
    var list = new ArrayList<Integer>();
    var authorsVector = string.split(",");
    try {
      for (String value : authorsVector) {
        list.add(Integer.parseInt(value));
      }
    } catch (Exception exception) {
      throw new LibraryException("Invalid Author(s) input. " + exception.getMessage(),
          ExceptionErrorEnum.INVALID_INPUT_NBCM);
    }
    return list;
  }

  public static void saveBook(String title, String isbn, Integer publisher, Double price,
      List<Integer> authors) {
    log.info(String.format("Starting the flow to register a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
    LibraryUtils.isOnlyNumbers(isbn);
    var book = Book.builder().title(title).isbn(isbn).publisherId(publisher).price(price).build();
    bookController.create(book, authors);
    log.info(String.format("Finishing the flow to register a Book. ISBN Last 4: %s",
        LibraryUtils.maskString(isbn, 0, (isbn.length() - 4))));
  }

  public static DefaultTableModel fromBookListToTableModel() {
    log.info("Starting the flow to list all Books.");
    var bookList = bookController.listAll();
    String[] column = {"ISBN", "Title", "Publisher", "Price"};
    var tableModel = new DefaultTableModel(column, 0);

    bookList.forEach(item -> {
      Object[] row = {item.getIsbn(), item.getTitle(), item.getPublisherId(), item.getPrice()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info("Finishing the flow to list all Books.");
    return tableModel;
  }

}
