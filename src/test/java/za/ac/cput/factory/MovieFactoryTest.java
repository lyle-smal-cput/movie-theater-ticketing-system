package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Movie;
import za.ac.cput.service.MovieService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/* MovieFactory.java
     Movie Factory Test class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
@SpringBootTest
class MovieFactoryTest {
@Autowired
MovieService movieService;
    @Test
    void createMovie() throws IOException {

        String f1Path = "C:/Users/27604/Downloads/f1.jpeg";
        byte[] f1Bytes = Files.readAllBytes(Paths.get(f1Path));

        Movie movie1 = new MovieFactory().createMovie(

                "F1: The Movie",
                "Sports",
                125,
                "In the 1990s, Sonny Hayes was Formula 1's most promising driver until an accident on the track nearly ended his career. Thirty years later, the owner of a struggling Formula 1 team convinces Sonny to return to racing and become the best in the world. ",
                16,
                "Apple",
                "3D",
                350,
        f1Bytes);
        //movie = movieService.create(movie);
        movie1 = movieService.create(movie1);
        assertNotNull(movie1);
        System.out.println(movie1);


    }

}