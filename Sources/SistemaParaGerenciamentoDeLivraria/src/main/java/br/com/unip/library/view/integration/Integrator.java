package br.com.unip.library.view.integration;

import br.com.unip.library.exception.ExceptionErrorEnum;
import br.com.unip.library.exception.LibraryException;
import br.com.unip.library.util.LibraryUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class Integrator {

  public static Double fromStringToDouble(String price){
    try{
      return Double.valueOf(price);
    } catch (Exception exception){
      throw new LibraryException("Invalid input on PRICE field!", ExceptionErrorEnum.INVALID_TEXT);
    }
  }

  public static List<Integer> fromAuthorsStringToList(String string){
    var list = new ArrayList<Integer>();
    if (Boolean.TRUE.equals(LibraryUtils.isValidAuthorsInput(string))){
      var authorsVector = string.split(",");
      for(String value : authorsVector){
        list.add(Integer.parseInt(value));
      }
    }
    return list;
  }

  public static String getJTextString(JTextField textField){
    var text = textField.getText();
    if (text == null || text.isBlank() || text.isEmpty()){
      throw new LibraryException("Invalid input on " + textField.getName() + " field!", ExceptionErrorEnum.INVALID_TEXT);
    }
    return textField.getText();
  }

}
