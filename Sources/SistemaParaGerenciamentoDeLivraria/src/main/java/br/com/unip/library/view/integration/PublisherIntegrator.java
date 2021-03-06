package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.PublisherControllerImpl;
import br.com.unip.library.model.entity.Publisher;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherIntegrator {

  private static final String[] column = {"ID", "Name", "URL"};

  private static final Logger log = LoggerFactory.getLogger(PublisherIntegrator.class);

  private static final PublisherControllerImpl publisherController = new PublisherControllerImpl();

  public static void deletePublisherById(Integer id) {
    log.info(String.format("Starting the flow to delete a Publisher. ID: %d", id));
    publisherController.delete(id);
    log.info(String.format("Finishing the flow to delete a Publisher. ID: %d", id));
  }

  public static void updatePublisherFields(Integer id, String name, String url) {
    log.info(String.format("Starting the flow to update a Publisher. ID: %d", id));
    publisherController.update(id, name, url);
    log.info(String.format("Finishing the flow to update a Publisher. ID: %d", id));
  }

  public static void savePublisher(String name, String url) {
    log.info(String.format("Starting the flow to register a Publisher. URL: %s", url));
    var publisher = Publisher
        .builder()
        .name(name)
        .url(url)
        .build();
    publisherController.create(publisher);
    log.info(String.format("Finishing the flow to register a Publisher. URL: %s", url));
  }

  public static DefaultTableModel fromPublisherListedByNameToTableModel(String name) {
    log.info(
        String.format("Starting the flow to list Publishers by name that contains (%s)", name));
    var publisherList = publisherController.findByNameThatContains(name);
    var tableModel = new DefaultTableModel(column, 0);
    publisherList.forEach(publisher -> {
      Object[] row = {publisher.getPublisherId(), publisher.getName(), publisher.getUrl()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info(
        String.format("Finishing the flow to list Publishers by name that contains (%s)", name));
    return tableModel;
  }

  public static DefaultTableModel findPublisherById(Integer id) {
    log.info("Starting the flow to list Publisher by ID");
    var publisher = publisherController.findById(id);
    var tableModel = new DefaultTableModel(column, 0);
    Object[] row = {publisher.getPublisherId(), publisher.getName(), publisher.getUrl()};
    tableModel.addRow(row);
    tableModel.fireTableDataChanged();
    log.info("Finishing the flow to list Publisher by ID");
    return tableModel;
  }

  public static DefaultTableModel fromPublishersListToTableModel() {
    log.info("Starting the flow to list all Publishers.");
    var publisherList = publisherController.listAll();
    var tableModel = new DefaultTableModel(column, 0);
    publisherList.forEach(publisher -> {
      Object[] row = {publisher.getPublisherId(), publisher.getName(), publisher.getUrl()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info("Finishing the flow to list all Publishers.");
    return tableModel;
  }
}
