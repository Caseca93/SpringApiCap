package org.github.caseca.rest.controller;

import org.github.caseca.domain.entity.Movie;
import org.github.caseca.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/{id}")
    public Movie getMovieById( @PathVariable("id") Long id ) {
        return service.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie save( @RequestBody Movie movie ) {
        return service.save(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Long id ){
       service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update ( @PathVariable Long id, @RequestBody Movie movie ){
       service.update(id, movie);
    }

    @GetMapping
    public List<Movie> find(Movie filter){
      return service.find(filter);
    }
}
