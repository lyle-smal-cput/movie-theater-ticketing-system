package za.ac.cput.service;
/* IMovie Service.java
     Schedule Service class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import za.ac.cput.domain.Movie;

import java.util.List;

public interface IMovieService extends IService<Movie, Long>{
    List<Movie> findByGenre(String genre);
    List<Movie> findByTitle(String title);
    List<Movie> getAll();
}
