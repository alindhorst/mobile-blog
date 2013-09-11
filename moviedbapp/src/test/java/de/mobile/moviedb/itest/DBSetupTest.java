package de.mobile.moviedb.itest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mobile.moviedb.entities.Movie;
import de.mobile.moviedb.itest.config.ITestPersistenceConfig;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITestPersistenceConfig.class})
public class DBSetupTest {

    @PersistenceContext(unitName = "movie-db")
    private EntityManager entityManager;

    @Test
    public void checkDBIsAvailable() {
        List resultList = entityManager.createNamedQuery(Movie.FIND_ALL_QUERY).getResultList();
        assertThat(resultList.size(), is(0));
    }
}
