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

    @Test
    void createSchedule() {
        Branch branch = BranchFactory.createBranch("Canal Walk", 10);
        Movie movie = MovieFactory.createMovie("MO89","Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D");
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
        Schedule schedule = ScheduleFactory.createSchedule("D84", LocalTime.of(14,25,54), LocalTime.of(17,35,25), LocalDate.of(2025,03,16), false, movie, theaterRoom);
        assertNotNull(schedule);
        System.out.println(schedule);
    }
}