package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Movie;
import za.ac.cput.repository.MovieRepository;

import java.util.List;
@Service
public class MovieService implements IMovieService {

    private MovieRepository repository;

    @Autowired
    MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movie create (Movie movie){
        return repository.save(movie);
    }

    @Override
    public Movie read (String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Movie update (Movie movie){
        return this.repository.save(movie);
    }

    @Override
    public boolean delete(String id){
        this.repository.deleteById(id);
        return true;
    }

    public byte[] getImage(String id) {
        Movie movie = this.repository.findById(id).orElse(null);
        if (movie != null) {
            return movie.getImage(); // assuming Movie has getImage()
        }
        return null; // or throw an exception if movie not found
    }

    @Override
    public List<Movie> getAll(){
        return this.repository.findAll();
    }
}
