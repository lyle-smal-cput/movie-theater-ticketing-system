package za.ac.cput.repository;
/* Schedule Repository.java
        Schedule Repository Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.Schedule;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByScheduleId(Long scheduleId);
    List<Schedule> findByDate(LocalDate date);
    List <Schedule> findByStartTime(LocalTime startTime);
    List<Schedule> findByEndTime(LocalTime endTime);
    List<Schedule> findByStartTimeAndEndTime(LocalTime startTime, LocalTime endTime);
    List<Schedule> findByIsFinishedAiring(boolean isFinishedAiring);
    List<Schedule> findByTheaterRoomTheaterRoomId(Long theaterRoomId);
    List<Schedule> findByMovie(Movie movie);


}
