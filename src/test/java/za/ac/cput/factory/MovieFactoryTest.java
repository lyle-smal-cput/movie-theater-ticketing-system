package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Movie;
import static org.junit.jupiter.api.Assertions.*;

/* MovieFactory.java
     Movie Factory Test class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
class MovieFactoryTest {

    @Test
    void createMovie() {
        Movie movie = new MovieFactory().createMovie("65H", "The Final Destination", "Horror", 96, "Supernatural spin on '90s teen horror", 15, "NewLine", "3D");
        assertNotNull(movie);
        System.out.println(movie);
    }

}