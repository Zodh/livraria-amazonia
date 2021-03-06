package br.com.unip.library.model.bo;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Author;
import lombok.Getter;

@Getter
public class AuthorBO {

  private final String name;

  private final String fname;

  public AuthorBO(Author author) {
    this.name = author.getName();
    this.fname = author.getFname();
    checkIfNameIsValid();
    checkIfFNameIsValid();
  }

  public Author toAuthor() {
    return Author
        .builder()
        .name(name)
        .fname(fname)
        .build();
  }

  private void checkIfNameIsValid() {
    var message = "";
    if (this.name == null || this.name.isBlank()) {
      message = "Author name is null, empty or just whitespaces!";
    }
    if (this.name != null && this.name.length() > 25) {
      message = "The name cannot contain more than 25 characters!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_AUTHOR_BO);
    }
  }

  private void checkIfFNameIsValid() {
    var message = "";
    if (this.fname == null || this.fname.isBlank()) {
      message = "Author FName is null, empty or just whitespaces!";
    }
    if (this.fname != null && this.fname.length() > 25) {
      message = "The Fantasy Name cannot contain more than 25 characters!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_AUTHOR_BO);
    }
  }
}
