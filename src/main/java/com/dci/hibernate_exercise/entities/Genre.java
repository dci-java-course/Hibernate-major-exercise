package com.dci.hibernate_exercise.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "movies", callSuper = true)
@ToString(exclude = "movies")
public class Genre extends BaseEntity {

  private String name;

  @OneToMany
  @JoinColumn(name = "genre_id")
  private List<Movie> movies;
}