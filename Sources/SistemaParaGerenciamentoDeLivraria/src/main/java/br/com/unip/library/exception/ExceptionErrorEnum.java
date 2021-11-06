package br.com.unip.library.exception;

public enum ExceptionErrorEnum {

  CREATE_BOOK("Service Create Book"),
  CREATE_BOOK_BO("Create Book Business Object"),
  LIST_BOOKS("Service List All Books"),
  FIND_BOOK_BY_ISBN("Service Find a Book by ISBN"),
  UPDATE_BOOK("Service Update Book"),
  DELETE_BOOK("Service Delete Book"),

  CREATE_AUTHOR("Service Create Author"),
  CREATE_AUTHOR_BO("Create Author Business Object"),
  LIST_AUTHORS("Service List All Authors"),
  FIND_AUTHOR_BY_ID("Service Find an Author by ID"),
  UPDATE_AUTHOR("Service Update Author"),
  DELETE_AUTHOR("Service Delete Author"),

  CREATE_PUBLISHER("Service Create Publisher"),
  CREATE_PUBLISHER_BO("Create Publisher Business Object"),
  LIST_PUBLISHERS("Service List All Publishers"),
  FIND_PUBLISHER_BY_ID("Service Find a Publisher by ID"),
  UPDATE_PUBLISHER("Service Update Publisher"),
  DELETE_PUBLISHER("Service Delete Publisher"),

  ERROR_CREATING_DAO("DAO Factory Constructor");

  public final String actionLabel;

  ExceptionErrorEnum(String actionLabel) {
    this.actionLabel = actionLabel;
  }

  @Override
  public String toString() {
    return actionLabel;
  }
}
