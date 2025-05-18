package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.Schedule;
import za.ac.cput.domain.TheaterRoom;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

/* ScheduleFactoryTest.java
     Schedule Factory Test class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
class ScheduleFactoryTest {
    Movie movie = new Movie.MovieBuilder().setMovieId("MO89").setTitle("Venom").setAgeRestriction(18).setDescription("The never ending adventures").setDistributor("Dragon Studios").setGenre("Sci-Fi").setDurationMinutes(89).setViewType("2D").build();
    Branch branch = new Branch.Builder().setBranchId("CW").setLocation("Canal Walk").setNumberOfTheaterRooms(10).build();
    TheaterRoom theaterRoom = new TheaterRoom.Builder().setTheaterRoomId("CW9").setRoomNumber(9).set3DSupported(false).setBranch(branch).setCapacity(45).setSeatsAvailable(10).build();

    @Test
    void createSchedule() {
        Schedule schedule = new ScheduleFactory().createSchedule("D84", LocalTime.of(14,25,54), LocalTime.of(17,35,25), LocalDate.of(2025,03,16), false, movie, theaterRoom);
        assertNotNull(schedule);
        System.out.println(schedule);
    }
}