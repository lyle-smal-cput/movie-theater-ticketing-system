package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.htmlunit.webdriver.LocalHostWebConnectionHtmlUnitDriver;
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
class ScheduleControllerTest {

    private final ScheduleController scheduleController;

    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("MO89","Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D", 150);
    public static Schedule schedule = ScheduleFactory.createSchedule("546", LocalTime.of(2, 23), LocalTime.of(3, 30), LocalDate.of(2025, 03, 16), false, movie, theaterRoom);


    @Autowired
    ScheduleControllerTest(ScheduleController scheduleController){
        this.scheduleController = scheduleController;
    }

    @Test
    void getScheduleById() {
        Schedule schd = scheduleController.read(schedule.getScheduleId());
        assertNotNull(schd);
        System.out.println(schd);
    }

    @Test
    void updateSchedule() {
        Schedule updatedSchedule = new Schedule.ScheduleBuilder()
                .copy(schedule)
                .setScheduleId("523")
                .build();
    }

    @Test
    void createSchedule() {
        Schedule createdSchedule = scheduleController.create(schedule);
        assertNotNull(createdSchedule);
        System.out.println(createdSchedule);
    }

}