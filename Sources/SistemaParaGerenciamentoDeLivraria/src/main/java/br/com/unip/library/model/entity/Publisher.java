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
@Table(name = "publishers")
@Builder(access = AccessLevel.PUBLIC)
public class Publisher {

  @Id
  @Column(name = "publisher_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_publisher_id")
  @SequenceGenerator(name = "seq_publisher_id", sequenceName = "seq_publisher_id", allocationSize = 1)
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
