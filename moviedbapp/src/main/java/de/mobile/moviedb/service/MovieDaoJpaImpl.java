package de.mobile.moviedb.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import de.mobile.moviedb.entities.Movie;

@Repository
public class MovieDaoJpaImpl implements MovieDao {
    
    @PersistenceContext(unitName = "movie-db")
    private EntityManager entityManager;

    @Override
    public Movie createMovie(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    @Override
    public void deleteMovie(Movie movie) {
        entityManager.remove(movie);
    }

    @Override
    public List<Movie> findMovieBy(MovieSearchParameter movieSearchParameter, String... values) {
        switch (movieSearchParameter) {
            default:
                return entityManager.createNamedQuery(Movie.FIND_ALL_QUERY).getResultList();
        }
    }
}
