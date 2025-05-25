package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByTitle(String title);
    List<Movie> findByMovieId(String movieId);
    List<Movie> findByDistributor(String distributor);
    List<Movie> findByGenre(String genre);
    List<Movie> findByViewType(String viewType);
    List<Movie> findByDurationMinutes(int durationMinutes);


}
