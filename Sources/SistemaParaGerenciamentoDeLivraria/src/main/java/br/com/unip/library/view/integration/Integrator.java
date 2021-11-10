package br.com.unip.library.view.integration;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.model.entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class Integrator {

  public static Integer fromStringToInteger(String publisher) {
    try {
      return Integer.valueOf(publisher);
    } catch (Exception exception) {
      throw new LibraryException("Invalid input on Integer field!",
          ExceptionErrorEnum.INVALID_TEXT);
    }
  }

  public static Double fromStringToDouble(String price) {
    try {
      return Double.valueOf(price);
    } catch (Exception exception) {
      throw new LibraryException("Invalid input on Double field!", ExceptionErrorEnum.INVALID_TEXT);
    }
  }

  public static String getJTextString(JTextField textField) {
    var text = textField.getText();
    if (text == null || text.isBlank() || text.isEmpty()) {
      throw new LibraryException("Invalid input on " + textField.getName() + " field!",
          ExceptionErrorEnum.INVALID_TEXT);
    }
    return textField.getText();
  }
}