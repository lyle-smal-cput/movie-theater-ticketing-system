package za.ac.cput.controller;
/* Schedule Controller Test.java
        Schedule Controller Test Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025*/
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduleControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/movie-theater-ticketing-system/schedule";

   private static String lifePath = "C:/Users/27604/Downloads/f1.jpeg";
    private static byte[] lifeBytes;

    static {
        try {
            lifeBytes = Files.readAllBytes(Paths.get(lifePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ScheduleController scheduleController;

    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D", 150, lifeBytes);
    public static Schedule schedule = ScheduleFactory.createSchedule(LocalTime.of(2, 23), LocalTime.of(3, 30), LocalDate.of(2025, 03, 16), false, movie, theaterRoom);


  @Test
    void create() {
      String url = BASE_URL + "/create";
      ResponseEntity<Schedule> postResponse = restTemplate.postForEntity(url, schedule, Schedule.class);
      assertNotNull(postResponse);
      Schedule createdSchedule = postResponse.getBody();
      assertEquals(schedule.getScheduleId(), createdSchedule.getScheduleId());
      System.out.println("Created:" + createdSchedule);
  }

  @Test
    void read() {
      String url = BASE_URL + "/read/" + schedule.getScheduleId();
      ResponseEntity<Schedule> response = this.restTemplate.postForEntity(url, schedule, Schedule.class);
      assertEquals(schedule.getScheduleId(), response.getBody().getScheduleId());
      System.out.println("Read:" + schedule);
  }

  @Test
    void update() {
      String url = BASE_URL + "/update";
      Schedule updatedSchedule = new Schedule.ScheduleBuilder().copy(schedule).setIsFinishedAiring(true).build();
      this.restTemplate.put(url, updatedSchedule);
      ResponseEntity<Schedule> response = restTemplate.getForEntity(BASE_URL + "/read/" + updatedSchedule.getScheduleId(), Schedule.class);
      assertEquals(response.getStatusCode(), HttpStatus.OK);
      assertNotNull(response.getBody());
      assertEquals(updatedSchedule.getScheduleId(), response.getBody().getScheduleId());
      System.out.println("Updated:" + response.getBody());

  }

  @Test
    void delete() {
      String url = BASE_URL + "/delete/" + schedule.getScheduleId();
      this.restTemplate.delete(url);
      ResponseEntity<Schedule> response = this.restTemplate.getForEntity(BASE_URL + "/read/" + schedule.getScheduleId(), Schedule.class);
      assertNull(response.getBody());
      System.out.println("Deleted:" + "true");
  }

  @Test
    void getAll() {
      String url = BASE_URL + "/getAll";
      ResponseEntity<Schedule[]> response = this.restTemplate.getForEntity(url, Schedule[].class);
      assertNotNull(response.getBody());
      assertTrue(response.getBody().length > 0);
      System.out.println("Get All:" );
      for (Schedule schedule : response.getBody()) {
          System.out.println(schedule);
      }
  }
}