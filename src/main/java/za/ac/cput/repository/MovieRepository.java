package za.ac.cput.repository;
/* Movie Repository.java
        Movie Repository Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Movie;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByDistributor(String distributor);
    List<Movie> findByGenre(String genre);
    List<Movie> findByViewType(String viewType);
    List<Movie> findByDurationMinutes(int durationMinutes);
    List<Movie> findByPrice(int price);


}
