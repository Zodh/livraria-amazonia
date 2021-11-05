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
  DELETE_AUTHOR("Service Delete Author");

  public final String actionLabel;

  ExceptionErrorEnum(String actionLabel) {
    this.actionLabel = actionLabel;
  }

  @Override
  public String toString() {
    return actionLabel;
  }
}
