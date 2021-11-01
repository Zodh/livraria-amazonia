package br.com.unip.library.exception;

import javax.swing.JOptionPane;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PUBLIC)
public class LibraryException extends RuntimeException {

  private final String message;
  private final ExceptionErrorEnum action;

  public LibraryException(String message, ExceptionErrorEnum action) {
    super(message);
    this.message = message;
    this.action = action;
    JOptionPane.showMessageDialog(
        null,
        String.format("Message: %s%nAction: %s", message, action),
        "Error",
        JOptionPane.ERROR_MESSAGE);
  }
}
