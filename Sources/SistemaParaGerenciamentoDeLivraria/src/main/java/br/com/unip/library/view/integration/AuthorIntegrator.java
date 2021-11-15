package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.AuthorControllerImpl;
import br.com.unip.library.model.entity.Author;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorIntegrator {

  private static final String[] column = {"ID", "Name", "Pseudonym"};

  private static final Logger log = LoggerFactory.getLogger(AuthorIntegrator.class);

  private static final AuthorControllerImpl authorController = new AuthorControllerImpl();

  public static DefaultTableModel fromAuthorListedByNameToTableModel(String name){
    log.info(String.format("Starting the flow to list Authors by name that contains (%s)", name));
    var bookList = authorController.findByNameThatContains(name);
    String[] column = {"ID", "Name", "Pseudonym"};
    var tableModel = new DefaultTableModel(column, 0);

    bookList.forEach(author -> {
      Object[] row = {author.getAuthorId(), author.getName(), author.getFname()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Authors by name that contains (%s)", name));
    return tableModel;
  }

  public static DefaultTableModel fromAuthorListedByPseudonymToTableModel(String pseudonym){
    log.info(String.format("Starting the flow to list Authors by pseudonym that contains (%s)", pseudonym));
    var bookList = authorController.findByPseudonymThatContains(pseudonym);
    var tableModel = new DefaultTableModel(column, 0);

    bookList.forEach(author -> {
      Object[] row = {author.getAuthorId(), author.getName(), author.getFname()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Authors by pseudonym that contains (%s)", pseudonym));
    return tableModel;
  }

  public static final DefaultTableModel findAuthorById(Integer id){
    log.info(String.format("Starting the flow to list Author by ID"));
    var author = authorController.findById(id);
    var tableModel = new DefaultTableModel(column, 0);
    Object[] row = {author.getAuthorId(), author.getName(), author.getFname()};
    tableModel.addRow(row);
    tableModel.fireTableDataChanged();
    log.info(String.format("Finishing the flow to list Author by ID"));
    return tableModel;
  }

  public static void deleteAuthorById(Integer id) {
    log.info(String.format("Starting the flow to delete an Author. ID: %d", id));
    authorController.delete(id);
    log.info(String.format("Finishing the flow to delete an Author. ID: %d", id));
  }

  public static void updateAuthorFields(Integer id, String name, String fname) {
    log.info(String.format("Starting the flow to update an Author. ID: %d", id));
    authorController.update(id, name, fname);
    log.info(String.format("Finishing the flow to update an Author. ID: %d", id));
  }

  public static void saveAuthor(String name, String fname) {
    log.info(String.format("Starting the flow to register an author. Pseudonym: %s", fname));
    var author = Author
        .builder()
        .name(name)
        .fname(fname)
        .build();
    authorController.create(author);
    log.info(String.format("Finishing the flow to register an author. Pseudonym: %s", fname));
  }

  public static DefaultTableModel fromAuthorsListToTableModel() {
    log.info("Starting the flow to list all Authors.");
    var authorList = authorController.listAll();
    String[] column = {"ID", "Name", "Pseudonym"};
    var tableModel = new DefaultTableModel(column, 0);

    authorList.forEach(author -> {
      Object[] row = {author.getAuthorId(), author.getName(), author.getFname()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info("Finishing the flow to list all Authors.");
    return tableModel;
  }

}
