package de.mobile.moviedb.service;

import java.util.List;

import de.mobile.moviedb.entities.Movie;

/**
 *
 * @author alindhorst
 */
public interface MovieService {

    Movie createMovie(Movie movie);

    Movie createMovie(String title, int year, Movie.Genre genre);

    void deleteMovie(Movie movie);

    List<Movie> getMoviesBy(MovieSearchParameter param, String... values);

    List<Movie> listAll();
    
}
