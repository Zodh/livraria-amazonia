package br.com.unip.model.entity;

import com.google.gson.Gson;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "publishers")
@Builder(access = AccessLevel.PUBLIC)
public class Publisher {

  @Id
  @Column(name = "publisher_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer publisherId;

  @Column(name = "name")
  private String name;

  @Column(name = "url")
  private String url;

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
