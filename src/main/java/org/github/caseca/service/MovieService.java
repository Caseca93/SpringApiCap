package org.github.caseca.service;

import org.github.caseca.domain.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie save (Movie movie);

    void update(Long id, Movie movie);

    void delete(Long id);

    List<Movie> find (Movie filter);

    Movie getMovieById (Long id);
}
