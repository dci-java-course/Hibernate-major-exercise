package com.dci.hibernate_exercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dci.hibernate_exercise.entities.Actor;
import com.dci.hibernate_exercise.entities.Genre;
import com.dci.hibernate_exercise.entities.Movie;
import com.dci.hibernate_exercise.repository.ActorRepository;
import com.dci.hibernate_exercise.repository.MovieRepository;

import java.util.Arrays;
import java.util.List;

public class JdbcApplication {

  public static void main(String[] args) {

    final SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Movie.class)
        .addAnnotatedClass(Actor.class)
        .addAnnotatedClass(Genre.class)
        .buildSessionFactory();

    final Session session = sessionFactory.openSession();

    final MovieRepository movieRepository = new MovieRepository(session.getSession());
    final ActorRepository actorRepository = new ActorRepository(session.getSession());
    Actor savedActor = actorRepository.save(new Actor("John", "Smith", 1970, null));

    movieRepository.save(new Movie("Predator", 1980, Arrays.asList(savedActor), null));
    System.out.println(movieRepository.findAllWithActors().get(0).getActors().size()); // dangerous call - for demo purposes only
  }
}