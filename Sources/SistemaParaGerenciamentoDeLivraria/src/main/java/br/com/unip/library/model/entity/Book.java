package br.com.unip.library.model.entity;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Builder(access = AccessLevel.PUBLIC)
public class Book implements Serializable {

  @Column(name = "title")
  private String title;

  @Id
  @Column(name = "isbn")
  private String isbn;

  @Column(name = "publisher_id")
  private Integer publisherId;

  @Column(name = "price")
  private Double price;

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
