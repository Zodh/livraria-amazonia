package br.com.unip.library.service.publisher;

import static br.com.unip.library.util.LibraryUtils.showInfo;

import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.PublisherBO;
import br.com.unip.library.model.entity.Publisher;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherServiceImpl implements PublisherService {

  private static final Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);

  private final PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  @Override
  public void create(Publisher publisher) {
    if (Boolean.TRUE.equals(isValidNewPublisher(publisher))) {
      try {
        publisherDAO.create(publisher);
        showInfo("Success", String
            .format("Publisher successfully saved!%nPublisher name: %s%nPublisher URL: %s",
                publisher.getName(), publisher.getUrl()));
      } catch (Exception exception) {
        throw new LibraryException(
            "Ooops... Error trying to save a new Publisher. Try again.\nMessage: " + exception
                .getMessage(),
            ExceptionErrorEnum.CREATE_PUBLISHER);
      }
    }
  }

  @Override
  public List<Publisher> listAll() {
    try {
      return publisherDAO.listAll();
    } catch (Exception exception) {
      throw new LibraryException("Error trying to list all Publishers. " + exception.getMessage(),
          ExceptionErrorEnum.LIST_PUBLISHERS);
    }
  }

  @Override
  public List<Publisher> findByNameThatContains(String name) {
    try {
      return publisherDAO.findByNameThatContains(name);
    } catch (Exception exception) {
      throw new LibraryException("Error trying to list Publishers by Name",
          ExceptionErrorEnum.FIND_PUBLISHER_BY_NAME);
    }
  }

  @Override
  public Publisher findById(Integer id) {
    try {
      var publisher = publisherDAO.findById(id);
      if (publisher == null) {
        throw new Exception("A Publisher with this ISBN does not exists!");
      }
      return publisher;
    } catch (Exception exception) {
      throw new LibraryException(
          "Error trying to find a Publisher by ID. " + exception.getMessage(),
          ExceptionErrorEnum.FIND_PUBLISHER_BY_ID);
    }
  }

  @Override
  public void update(Integer id, String name, String url) {
    try {
      var stringBuilder = new StringBuilder();
      var publisher = findById(id);
      if (name != null && !name.isBlank() && !name.equals(publisher.getName())) {
        publisher.setName(name);
        stringBuilder.append("Publisher name has been updated!\n");
      }
      if (url != null && !url.isBlank() && !url.equals(publisher.getUrl())) {
        publisher.setUrl(url);
        stringBuilder.append("Publisher URL has been updated!\n");
      }
      var updatedFields = stringBuilder.toString();
      if (!updatedFields.isBlank()) {
        publisherDAO.update(publisher);
        showInfo("Publisher Successfully Updated", updatedFields);
      } else {
        showInfo("The Publisher has not been updated",
            "Invalid information to update the Publisher.");
      }
    } catch (Exception exception) {
      throw new LibraryException(
          "Error Trying to Update Publisher. Try again.\nMessage: " + exception.getMessage(),
          ExceptionErrorEnum.UPDATE_PUBLISHER);
    }
  }

  @Override
  public void delete(Integer id) {
    try {
      publisherDAO.deleteById(id);
      showInfo("Success", "Publisher with ID " + id + " has been deleted!");
    } catch (Exception exception) {
      throw new LibraryException(
          "Error Trying to Delete Publisher. Try again.\nMessage: " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_PUBLISHER);
    }
  }

  private Boolean isValidNewPublisher(Publisher publisher) {
    log.info("Checking if the data informed to register a publisher is valid.");
    return new PublisherBO(publisher).toPublisher() != null;
  }
}
