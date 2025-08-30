package za.ac.cput.controller;
/* Movie Controller Test.java
        Movie Controller Test Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025 */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Movie;
import za.ac.cput.factory.CardFactory;
import za.ac.cput.factory.MovieFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class MovieControllerTest {

    private static String lifePath = "C:/Users/27604/Downloads/f1.jpeg";
    private static byte[] lifeBytes;

    static {
        try {
            lifeBytes = Files.readAllBytes(Paths.get(lifePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/movie-theater-ticketing-system/movie";

    private static Movie movie = new MovieFactory().createMovie("Life In a Year", "Romance", 120, "Life in a year, with you", 18, "Netflix", "2D", 44, lifeBytes);

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Movie> postResponse = this.restTemplate.postForEntity(url, movie, Movie.class);
        assertNotNull(postResponse);
        Movie createdMovie = postResponse.getBody();
        assertEquals(movie.getMovieId(), createdMovie.getMovieId());
        System.out.println("Movie created: " + createdMovie);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + movie.getMovieId();
        ResponseEntity<Movie> response = this.restTemplate.getForEntity(url, Movie.class);
        assertEquals(movie.getMovieId(), response.getBody().getMovieId());
        System.out.println("Movie read: " + response.getBody());
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Movie updatedMovie = new Movie.MovieBuilder().copy(movie).setTitle("Our Summer")
                .build();
        this.restTemplate.put(url, updatedMovie);
        ResponseEntity<Movie> response = restTemplate.getForEntity(BASE_URL + "/read/" + updatedMovie.getMovieId(), Movie.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(movie.getMovieId(), response.getBody().getMovieId());
        System.out.println("Movie updated: " + response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + movie.getMovieId();
        this.restTemplate.delete(url);
        ResponseEntity<Movie> response = this.restTemplate.getForEntity(BASE_URL + "/read/" + movie.getMovieId(), Movie.class);
        assertNull(response.getBody());
        System.out.println("Movie deleted: " + "true");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Movie[]> response = this.restTemplate.getForEntity(url, Movie[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("Movie Get All: " );
        for (Movie movie : response.getBody()) {
            System.out.println(movie);
        }
    }
}