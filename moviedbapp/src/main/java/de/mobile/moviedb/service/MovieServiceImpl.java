package de.mobile.moviedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.mobile.moviedb.entities.Movie;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao dao;

    @Override
    public List<Movie> listAll() {
        return dao.findMovieBy(null);
    }

    @Override
    public List<Movie> getMoviesBy(MovieSearchParameter param, String... values) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Movie createMovie(Movie movie) {
        return dao.createMovie(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        dao.deleteMovie(movie);
    }

    @Override
    public Movie createMovie(String title, int year, Movie.Genre genre) {
        return createMovie(new Movie(title, year, genre));
    }
}
