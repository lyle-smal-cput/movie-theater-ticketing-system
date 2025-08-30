package za.ac.cput.controller;
/* Movie Controller.java
     Movie Controller class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Movie;
import za.ac.cput.service.MovieService;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Movie")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping("create")
    public Movie create(@RequestBody Movie movie) {
        return service.create(movie);
    }


    @GetMapping("/read/{movieId}")
    public Movie read(@PathVariable Long movieId) {
        return service.read(movieId);
    }

    @PutMapping("/update")
    public Movie update(@RequestBody Movie movie) {

        return service.update(movie);
    }

    @DeleteMapping("/delete/{movieId}")
    public void delete(@PathVariable Long movieId) {

        service.delete(movieId);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> findByGenre(@PathVariable String genre) {
        return service.findByGenre(genre);
    }

    @GetMapping("/title/{title}")
    public List<Movie> findByTitle(@PathVariable String title) {
        return service.findByTitle(title);
    }

    @GetMapping("/getAll")
    public List<Movie> getAll() {
        return service.getAll();
    }


}
