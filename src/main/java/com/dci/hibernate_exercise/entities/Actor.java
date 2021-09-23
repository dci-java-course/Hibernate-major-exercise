package com.dci.hibernate_exercise.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "actors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "movies", callSuper = true)
@ToString(exclude = "movies")
public class Actor extends BaseEntity {

  private String name;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "year_of_birth")
  private int yearOfBirth;

  @ManyToMany
  @JoinTable(name = "actors_to_movies",
      joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
  private List<Movie> movies = new ArrayList<Movie>();
}