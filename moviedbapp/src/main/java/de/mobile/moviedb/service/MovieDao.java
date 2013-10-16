package de.mobile.moviedb.service;

import java.util.List;

import de.mobile.moviedb.entities.Movie;

/**
 *
 * @author alindhorst
 */
public interface MovieDao {

    Movie createMovie(Movie movie);

    void deleteMovie(Movie movie);

    List<Movie> findMovieBy(MovieSearchParameter movieSearchParameter, String... values);
    
}
