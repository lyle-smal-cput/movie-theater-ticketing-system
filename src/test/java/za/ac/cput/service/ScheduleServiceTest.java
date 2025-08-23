package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.Schedule;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.factory.MovieFactory;
import za.ac.cput.factory.ScheduleFactory;
import za.ac.cput.factory.TheaterRoomFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScheduleServiceTest {
    @Autowired
    private ScheduleService service;


    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("MO89","Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D", 150);
    private static Schedule schedule = ScheduleFactory.createSchedule("596", LocalTime.of(2, 40), LocalTime.of(4, 40), LocalDate.of(2025,3, 16), false, movie, theaterRoom);


    @Test
    void create() {
        Schedule created = service.create(schedule);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Schedule read = service.read(schedule.getScheduleId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Schedule newSchedule = new Schedule.ScheduleBuilder().copy(schedule).setScheduleId("456")
                .build();
        Schedule updated = service.update(newSchedule);
        assertNotNull(updated);
        System.out.println(updated);
    }



    //@Disabled
    @Test
    void getAll() {
        System.out.println(service.getAll());

    }

}