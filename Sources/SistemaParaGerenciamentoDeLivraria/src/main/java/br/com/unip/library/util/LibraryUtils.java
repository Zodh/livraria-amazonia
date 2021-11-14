package br.com.unip.library.util;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryUtils {

  private static final Logger log = LoggerFactory.getLogger(LibraryUtils.class);

  public static void showInfo(String title, String message) {
    log.info(String.format("Displaying title (%s) and message", title));
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  public static String maskString(String text, Integer start, Integer end) {
    log.info("Initializing mask method");
    try {
      if (text == null || text.equals("")) {
        return "";
      }
      if (start < 0) {
        start = 0;
      }
      if (end > text.length()) {
        end = text.length();
      }
      if (start > end) {
        throw new Exception("End index cannot be greater than start index.");
      }
      var maskLength = end - start;
      if (maskLength == 0) {
        return text;
      }
      var sbMaskString = new StringBuilder(maskLength);
      sbMaskString.append("*".repeat(maskLength));
      log.info("Ending mask method");
      return text.substring(0, start)
          + sbMaskString
          + text.substring(start + maskLength);
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Mask an Information",
          ExceptionErrorEnum.MASK_INFO);
    }
  }

  public static Boolean isOnlyNumbers(String numbers) {
    log.info("Verifying if String has only numbers");
    var pattern = Pattern.compile("^[0-9]*$");
    if (Boolean.FALSE.equals(pattern.matcher(numbers).matches())) {
      throw new LibraryException("Input only numbers", ExceptionErrorEnum.INVALID_INPUT_NB);
    }
    return true;
  }
}
