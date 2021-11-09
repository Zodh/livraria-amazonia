package br.com.unip.library.util;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class LibraryUtils {

  public static void showInfo(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  public static String maskString(String text, Integer start, Integer end) {
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
      return text.substring(0, start)
          + sbMaskString
          + text.substring(start + maskLength);
    } catch (Exception exception) {
      throw new LibraryException("Error Trying to Mask an Information",
          ExceptionErrorEnum.MASK_INFO);
    }
  }

  public static Boolean isValidAuthorsInput(String authors){
    var pattern = Pattern.compile("^[0-9]?(?:,\\d+?)*$");
    if(Boolean.FALSE.equals(pattern.matcher(authors).matches())){
      throw new LibraryException("Input only numbers and comma", ExceptionErrorEnum.INVALID_INPUT);
    }
    return true;
  }
}
