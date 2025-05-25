package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.Schedule;
import za.ac.cput.domain.TheaterRoom;

import java.time.LocalTime;
import java.util.List;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    List<Schedule> findByScheduleId(String scheduleId);
    List<Schedule> findByDate(String date);
    List <Schedule> findByStartTime(LocalTime startTime);
    List<Schedule> findByEndTime(LocalTime endTime);
    List<Schedule> findByStartTimeAndEndTime(LocalTime startTime, LocalTime endTime);
    List<Schedule> findByIsFinishedAiring(boolean isFinishedAiring);
    List<Schedule> findByTheaterRoom(TheaterRoom theaterRoom);
    List<Schedule> findByMovie(Movie movie);


}
