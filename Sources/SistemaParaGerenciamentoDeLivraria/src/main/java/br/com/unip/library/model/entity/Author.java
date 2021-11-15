package br.com.unip.library.model.entity;

import com.google.gson.Gson;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "authors")
@Builder(access = AccessLevel.PUBLIC)
public class Author {

  @Id
  @Column(name = "author_id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_author_id")
  @SequenceGenerator(name = "seq_author_id", sequenceName = "seq_author_id", allocationSize = 1)
  private Integer authorId;

  @Column(name = "name")
  private String name;

  @Column(name = "fname")
  private String fname;

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
