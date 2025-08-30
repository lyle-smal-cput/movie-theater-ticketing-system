package za.ac.cput.service;
/* Movie Service Test.java
        Movie Service Test Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025*/
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Movie;
import za.ac.cput.factory.MovieFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService service;

   private static String f1Path = "C:/Users/27604/Downloads/f1.jpeg";
   private static byte[] f1Bytes;

    static {
        try {
            f1Bytes = Files.readAllBytes(Paths.get(f1Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Movie movie = MovieFactory.createMovie( "How To Train Your Dragon", "Animation", 120, "A Viking breaks all rules and befriends a dragon he is supposed to kill. He decides to call him Toothless and they join forces to put an end to the terror that wreaks havoc in their respective worlds.", 13, "DreamWorks Animation", "3D", 150, f1Bytes);

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
        Movie updatedMovie = new Movie.MovieBuilder().copy(movie).setTitle("Our Summer")
                .build();
        Movie updated = service.update(updatedMovie);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());

    }

}