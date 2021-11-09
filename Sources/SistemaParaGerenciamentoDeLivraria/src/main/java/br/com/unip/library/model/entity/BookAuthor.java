package br.com.unip.library.model.entity;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booksauthors")
@Builder(access = AccessLevel.PUBLIC)
public class BookAuthor implements Serializable {

  @Id
  @Column(name = "isbn")
  private String isbn;

  @Id
  @Column(name = "author_id")
  private Integer authorId;

  @Column(name = "seq_no")
  private Integer seqNo;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookAuthor that = (BookAuthor) o;
    return Objects.equals(isbn, that.isbn) && Objects
        .equals(authorId, that.authorId) && Objects.equals(seqNo, that.seqNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isbn, authorId, seqNo);
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
