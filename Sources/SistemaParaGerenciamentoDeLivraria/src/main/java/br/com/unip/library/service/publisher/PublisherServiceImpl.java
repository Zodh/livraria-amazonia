package br.com.unip.library.service.publisher;

import static br.com.unip.library.util.LibraryUtils.showInfo;

import br.com.unip.library.dao.PublisherDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.PublisherBO;
import br.com.unip.library.model.entity.Publisher;
import java.util.List;

public class PublisherServiceImpl implements PublisherService {

  private final PublisherDAO publisherDAO = DAOFactory.getFactory().getPublisherDAO();

  @Override
  public void create(String name, String url) {
    var publisher = Publisher.builder().name(name).url(url).build();
    if (Boolean.TRUE.equals(isValidNewPublisher(publisher))) {
      try {
        publisherDAO.create(publisher);
        showInfo("Success", "Publisher successfully saved!");
      } catch (Exception exception) {
        throw new LibraryException(
            "Error trying to save a new Publisher. " + exception.getMessage(),
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
        publisherDAO.create(publisher);
        showInfo("Publisher Successfully Updated", updatedFields);
      } else {
        showInfo("The Publisher has not been updated",
            "Invalid information to update the Publisher.");
      }
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Update Publisher. " + exception.getMessage(),
          ExceptionErrorEnum.UPDATE_PUBLISHER);
    }
  }

  @Override
  public void delete(Integer id) {
    var publisher = findById(id);
    try {
      publisherDAO.delete(publisher);
      showInfo("Success", "Publisher with ID " + id + " has been deleted!");
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Delete Publisher. " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_PUBLISHER);
    }
  }

  private Boolean isValidNewPublisher(Publisher publisher) {
    return new PublisherBO(publisher).toPublisher() != null;
  }
}
