package br.com.unip.view;

import br.com.unip.dao.base.DAOFactory;

public class Application {

  public static void main(String[] args) {

    var factory = DAOFactory.getFactory();

    var bookDAO = factory.getBookDAO();
    var book = bookDAO.findById("es21230563525");
    var booksList = bookDAO.listAll();

    System.out.println(book);
    System.out.println("\n\n\n");
    booksList.forEach(System.out::println);
  }

}
