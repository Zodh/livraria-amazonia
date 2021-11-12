package br.com.unip.library.exception;

import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryException extends RuntimeException {

  private static final Logger log = LoggerFactory.getLogger(LibraryException.class);

  private final String message;
  private final ExceptionErrorEnum action;

  public LibraryException(String message, ExceptionErrorEnum action) {
    super(message);
    this.message = message;
    this.action = action;
    log.error(String.format("Message: %s%nAction: %s", message, action));
    if (action != ExceptionErrorEnum.CREATE_AUTHOR_BO
        && action != ExceptionErrorEnum.CREATE_PUBLISHER_BO
        && action != ExceptionErrorEnum.CREATE_BOOK_BO) {
      JOptionPane.showMessageDialog(
          null,
          String.format("Message: %s%nAction: %s", message, action),
          "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }
}
