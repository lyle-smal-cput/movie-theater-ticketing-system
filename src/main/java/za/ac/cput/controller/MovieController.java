package za.ac.cput.controller;

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
    public Movie read(@PathVariable String movieId) {

        return service.read(movieId);
    }

    @PutMapping("/update")
    public Movie update(@RequestBody Movie movie) {

        return service.update(movie);
    }

    @DeleteMapping("/delete/{movieId}")
    public void delete(@PathVariable String movieId) {

        service.delete(movieId);
    }

    @GetMapping("/getAll")
    public List<Movie> getAll() {
        return service.getAll();
    }


}
