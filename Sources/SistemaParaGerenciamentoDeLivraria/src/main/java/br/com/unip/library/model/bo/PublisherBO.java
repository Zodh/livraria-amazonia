package br.com.unip.library.model.bo;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Publisher;
import lombok.Getter;

@Getter
public class PublisherBO {

  private final String name;

  private final String url;

  public PublisherBO(Publisher publisher) {
    this.name = publisher.getName();
    this.url = publisher.getUrl();
    checkIfNameIsValid();
    checkIfUrlIsValid();
  }

  public Publisher toPublisher() {
    return Publisher
        .builder()
        .name(name)
        .url(url)
        .build();
  }

  private void checkIfNameIsValid() {
    var message = "";
    if (this.name == null || this.name.isBlank()) {
      message = "Publisher name is null, empty or just whitespaces!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_PUBLISHER_BO);
    }
  }

  private void checkIfUrlIsValid() {
    var message = "";
    if (this.url == null || this.url.isBlank()) {
      message = "Publisher URL is null, empty or just whitespaces!";
    }
    if (!message.equals("")) {
      throw new LibraryException(message, ExceptionErrorEnum.CREATE_AUTHOR_BO);
    }
  }
}
