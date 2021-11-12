package br.com.unip.library.view.integration;

import br.com.unip.library.controller.impl.PublisherControllerImpl;
import br.com.unip.library.model.entity.Publisher;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherIntegrator {

  private static final Logger log = LoggerFactory.getLogger(PublisherIntegrator.class);

  private static final PublisherControllerImpl publisherController = new PublisherControllerImpl();

  public static void savePublisher(String name, String url) {
    log.info("Starting the flow to register a Publisher.");
    var publisher = Publisher
        .builder()
        .name(name)
        .url(url)
        .build();
    publisherController.create(publisher);
    log.info("Finishing the flow to register a Publisher.");
  }

  public static DefaultTableModel fromPublishersListToTableModel() {
    log.info("Starting the flow to list all Publishers.");
    var publisherList = publisherController.listAll();
    String[] column = {"ID", "Name", "URL"};
    var tableModel = new DefaultTableModel(column, 0);

    publisherList.forEach(publisher -> {
      Object[] row = {publisher.getPublisherId(), publisher.getName(),publisher.getUrl()};
      tableModel.addRow(row);
    });
    tableModel.fireTableDataChanged();
    log.info("Finishing the flow to list all Publishers.");
    return tableModel;
  }

}
