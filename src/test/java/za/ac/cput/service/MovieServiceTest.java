package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Movie;
import za.ac.cput.factory.MovieFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService service;


    private static Movie movie = MovieFactory.createMovie("562", "Blues", "Comedy", 445, "The family of 5", 18, "Studio Dragon", "3D");

    @Test
    void create() {
        Movie created = service.create(movie);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Movie read = service.read(movie.getMovieId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Movie newMovie = new Movie.MovieBuilder().copy(movie).setTitle("Our Summer")
                .build();
        Movie updated = service.update(newMovie);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());

    }

}