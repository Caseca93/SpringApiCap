package org.github.caseca.repository;

import org.github.caseca.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "select m from Movie m where m.name like :name")
    List<Movie> encontrarPorNome(@Param("name") String name);
}
