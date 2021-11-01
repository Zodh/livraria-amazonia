package br.com.unip.library.util;

import javax.swing.JOptionPane;

public class LibraryUtils {

  public static void showInfo(String title, String message){
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

}
