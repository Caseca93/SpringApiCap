package org.github.caseca.repository;

import org.github.caseca.domain.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Movie save(Movie movie){
        entityManager.persist(movie);
        return movie;
    }

    @Transactional
    public Movie update(Movie movie){
        entityManager.merge(movie);
        return movie;
    }

    @Transactional
    public void remove(Long id){
        Movie movie = entityManager.find( Movie.class, id );
        entityManager.remove(movie);
    }

    @Transactional
    public List<Movie> findAll(){
        return entityManager
                .createQuery("from Movie", Movie.class)
                .getResultList();
    }
}
