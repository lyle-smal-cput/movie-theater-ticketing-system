package za.ac.cput.service;
/* Schedule Service Test.java
     Schedule Service Test Class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025*/

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScheduleServiceTest {
    @Autowired
    private ScheduleService service;

    private static String f1Path = "C:/Users/27604/Downloads/f1.jpeg";
    private static byte[] f1Bytes;

    static {
        try {
            f1Bytes = Files.readAllBytes(Paths.get(f1Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D", 150, f1Bytes);
    private static Schedule schedule = ScheduleFactory.createSchedule(LocalTime.of(2, 40), LocalTime.of(4, 40), LocalDate.of(2025,3, 16), false, movie, theaterRoom);


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
        Schedule newSchedule = new Schedule.ScheduleBuilder().copy(schedule).setIsFinishedAiring(true).build();
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