package za.ac.cput.service;
/* Movie Service.java
     Schedule Service class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Movie read (Long id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Movie update (Movie movie){
        return this.repository.save(movie);
    }

    @Override
    public boolean delete(Long id){
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Movie> findByGenre(String genre){
        return this.repository.findByGenre(genre);
    }

    @Override
    public List<Movie> findByTitle(String title){
        return this.repository.findByTitle(title);
    }

    public byte[] getImage(Long id) {
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
