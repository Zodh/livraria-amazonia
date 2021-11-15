package br.com.unip.library.exception;

public enum ExceptionErrorEnum {

  CREATE_BOOK("Service Create Book"),
  CREATE_BOOK_BO("Create Book Business Object"),
  LIST_BOOKS("Service List All Books"),
  UPDATE_BOOK("Service Update Book"),
  DELETE_BOOK("Service Delete Book"),
  FIND_BOOK_BY_ISBN("Service Find a Book by ISBN"),
  FIND_BOOK_BY_PUBLISHER_ID("Service List Book By Publisher Id"),
  FIND_BOOK_BY_TITLE("Service List Book By Title"),

  CREATE_AUTHOR("Service Create Author"),
  CREATE_AUTHOR_BO("Create Author Business Object"),
  LIST_AUTHORS("Service List All Authors"),
  FIND_AUTHOR_BY_ID("Service Find an Author by ID"),
  FIND_AUTHOR_BY_NAME("Service Find Authors by name"),
  FIND_AUTHOR_BY_PSEUDONYM("Service Find Authors by Pseudonym"),
  UPDATE_AUTHOR("Service Update Author"),
  DELETE_AUTHOR("Service Delete Author"),

  CREATE_PUBLISHER("Service Create Publisher"),
  CREATE_PUBLISHER_BO("Create Publisher Business Object"),
  LIST_PUBLISHERS("Service List All Publishers"),
  FIND_PUBLISHER_BY_NAME("Service Find Publishers by name"),
  FIND_PUBLISHER_BY_ID("Service Find a Publisher by ID"),
  UPDATE_PUBLISHER("Service Update Publisher"),
  DELETE_PUBLISHER("Service Delete Publisher"),

  CREATE_BOOK_AUTHOR("Service Create Book Author"),
  CREATE_BOOK_AUTHOR_BO("Create Book Author Business Object"),
  DELETE_BOOK_AUTHOR_BY_ISBN("Service Delete Book Author by ISBN"),
  DELETE_BOOK_AUTHOR_BY_AUTHOR_ID("Service Delete Book Author by Author ID"),

  CREATE_DAO("DAO Factory Constructor"),
  MASK_INFO("Mask Information"),
  INVALID_INPUT_NBCM("REGEX - Validating Input - Only Numbers and Commas"),
  INVALID_INPUT_NB("REGEX - Validating Input - Only Numbers"),
  INVALID_TEXT("Field validation - Invalid input");

  public final String actionLabel;

  ExceptionErrorEnum(String actionLabel) {
    this.actionLabel = actionLabel;
  }

  @Override
  public String toString() {
    return actionLabel;
  }
}
