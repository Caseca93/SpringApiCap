package org.github.caseca.service.impl;

import lombok.RequiredArgsConstructor;
import org.github.caseca.domain.entity.Movie;
import org.github.caseca.domain.repository.MovieRepository;
import org.github.caseca.exception.MovieNotFoundException;
import org.github.caseca.service.MovieService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void update(Long id, Movie movie) {
        movieRepository
                .findById(id)
                .map( movieExist -> {
                    movie.setId(movieExist.getId());
                    movieRepository.save(movie);
                    return movieExist;
                }).orElseThrow( () -> new MovieNotFoundException("Filme não encontrado!"));
    }

    @Override
    public void delete(Long id) {
        movieRepository.findById(id)
                .map( movie -> {
                    movieRepository.delete(movie);
                    return movie;
                }).orElseThrow( () -> new MovieNotFoundException("Filme não encontrado!"));
    }

    @Override
    public List<Movie> find(Movie filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filter, matcher);
        if(movieRepository.findAll(example).isEmpty()){
            throw new MovieNotFoundException("Nenhum filme cadastrado!");
        }
        return movieRepository.findAll(example);
    }

    @Override
    public Movie getMovieById(Long id) {
        return  movieRepository.findById(id)
                .orElseThrow( () -> new MovieNotFoundException("Filme não encontrado!"));
    }
}
