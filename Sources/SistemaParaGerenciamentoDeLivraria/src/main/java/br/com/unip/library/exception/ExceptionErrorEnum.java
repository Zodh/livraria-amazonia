package br.com.unip.library.exception;

public enum ExceptionErrorEnum {

  CREATE_BOOK("Create Book"),
  LIST_BOOKS("List All Books"),
  FIND_BOOK_BY_ID("Find a Book by ID"),
  UPDATE_BOOK("Update Book"),
  DELETE_BOOK("Delete Book");

  public final String actionLabel;

  ExceptionErrorEnum(String actionLabel) {
    this.actionLabel = actionLabel;
  }

  @Override
  public String toString() {
    return actionLabel;
  }
}
