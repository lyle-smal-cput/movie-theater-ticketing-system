package za.ac.cput.factory;

import za.ac.cput.domain.Movie;
import za.ac.cput.util.Helper;

/* MovieFactory.java
     Movie Factory class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
public class MovieFactory {

public static Movie createMovie(String movieId, String title, String genre, int durationMinutes, String description, int ageRestriction, String distributor, String viewType){
    if(Helper.isNullOrEmpty(movieId) || Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(genre) || Helper.isNullOrEmpty(distributor) || Helper.isNullOrEmpty(viewType) ){
        return null;
    }
   return new Movie.MovieBuilder()
           .setMovieId(movieId)
           .setTitle(title)
           .setGenre(genre)
           .setDurationMinutes(durationMinutes)
           .setDescription(description)
           .setAgeRestriction(ageRestriction)
           .setDistributor(distributor)
           .setViewType(viewType)
           .build();
}
}//end of class
