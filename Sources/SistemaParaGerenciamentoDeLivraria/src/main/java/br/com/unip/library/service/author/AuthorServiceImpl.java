package br.com.unip.library.service.author;

import static br.com.unip.library.util.LibraryUtils.showInfo;

import br.com.unip.library.dao.AuthorDAO;
import br.com.unip.library.dao.base.DAOFactory;
import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.bo.AuthorBO;
import br.com.unip.library.model.entity.Author;
import br.com.unip.library.service.bookauthor.BookAuthorServiceImpl;
import br.com.unip.library.view.TestMethods;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorServiceImpl implements AuthorService {

  private static final Logger log = LoggerFactory.getLogger(TestMethods.class);

  private final AuthorDAO authorDAO = DAOFactory.getFactory().getAuthorDAO();
  private final BookAuthorServiceImpl bookAuthorService = new BookAuthorServiceImpl();

  @Override
  public void create(Author author) {
    try {
      if (Boolean.TRUE.equals(isValidAuthor(author))) {
        authorDAO.create(author);
        showInfo("Success", String
            .format("Author successfully saved! "
                    + "%nName: %s "
                    + "%nFantasy Name: %s ", author.getName(),
                author.getFname()));
      }
    } catch (Exception exception) {
      throw new LibraryException("Error trying to save a new Author. " + exception.getMessage(),
          ExceptionErrorEnum.CREATE_AUTHOR);
    }
  }

  @Override
  public List<Author> listAll() {
    try {
      return authorDAO.listAll();
    } catch (Exception exception) {
      throw new LibraryException("Error trying to list all Authors. " + exception.getMessage(),
          ExceptionErrorEnum.LIST_AUTHORS);
    }
  }

  @Override
  public Author findById(Integer id) {
    try {
      var author = authorDAO.findById(id);
      if (author == null) {
        throw new Exception("An Author with this ID does not exists!");
      }
      return author;
    } catch (Exception exception) {
      throw new LibraryException("Error trying to find an Author by ID. " + exception.getMessage(),
          ExceptionErrorEnum.FIND_AUTHOR_BY_ID);
    }
  }

  @Override
  public void update(Integer id, String name, String fname) {
    var stringBuilder = new StringBuilder();
    var author = findById(id);
    try {
      if (name != null && !name.isBlank() && !name.equals(author.getName())
          && name.length() <= 25) {
        author.setName(name);
        stringBuilder.append("Author name has been updated!\n");
      }
      if (fname != null && !fname.isBlank() && !fname.equals(author.getFname())
          && fname.length() <= 25) {
        author.setFname(fname);
        stringBuilder.append("Author fname has been updated!\n");
      }
      var updatedFields = stringBuilder.toString();
      if (!updatedFields.isBlank()) {
        authorDAO.update(author);
        showInfo("Author Successfully Updated", updatedFields);
      } else {
        showInfo("Author has not been updated", "Invalid information to update the Author.");
      }
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Update Author. " + exception.getMessage(),
          ExceptionErrorEnum.UPDATE_AUTHOR);
    }
  }

  @Override
  public void delete(Integer id) {
    var author = findById(id);
    try {
      bookAuthorService.deleteBookAuthorsByAuthorId(id);
      authorDAO.delete(author);
      showInfo("Success", "Author with ID " + id + " has been deleted!");
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Delete Author. " + exception.getMessage(),
          ExceptionErrorEnum.DELETE_AUTHOR);
    }
  }

  private Boolean isValidAuthor(Author author) {
    log.info("Checking if the data informed to register an author is valid.");
    return new AuthorBO(author).toAuthor() != null;
  }
}
