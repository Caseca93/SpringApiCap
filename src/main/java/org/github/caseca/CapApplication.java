package org.github.caseca;

import org.github.caseca.domain.entity.Movie;
import org.github.caseca.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CapApplication {
    //TODO USAR O SPRING DATA FACILITA MAIS AINDA
    @Bean
    public CommandLineRunner init(@Autowired MovieRepository movieRepository){
        return args -> {
            System.out.println("Salvando filme");
            movieRepository.save(new Movie("Thor",
                                     "www.thor.com",
                                        "Ficção",
                            "Amor e Trovão"));
            movieRepository.save(new Movie("Harry Potter",
                                    "www.HarryPotter.com",
                                        "Ficção",
                            "Camera Secreta"));

            List<Movie> allMovies = movieRepository.findAll();
            allMovies.forEach(System.out::println);

            System.out.println("Atualizando Filme");
            allMovies.forEach( c -> {
                c.setGender(c.getGender() + " atualizou.");
                movieRepository.update(c);
            });

            List<Movie> allMoviess = movieRepository.findAll();
            allMovies.forEach(System.out::println);

            System.out.println("Deletando filme");
            movieRepository.findAll().forEach(c -> {
                movieRepository.remove(c.getId());
            });

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(CapApplication.class, args);
    }
}
