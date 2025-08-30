package za.ac.cput.factory;

import za.ac.cput.domain.Movie;
import za.ac.cput.domain.Schedule;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.util.Helper;
import java.time.LocalDate;
import java.time.LocalTime;

/* ScheduleFactory.java
     Schedule Factory class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */

public class ScheduleFactory {

    public static Schedule createSchedule(LocalTime startTime, LocalTime endTime, LocalDate date, boolean isFinishedAiring, Movie movie, TheaterRoom theaterRoom) {
        if(startTime == null || endTime == null || date == null || isFinishedAiring || movie == null || theaterRoom == null)  {
            return null;
        }
        return new Schedule.ScheduleBuilder()
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setIsFinishedAiring(isFinishedAiring)
                .setMovie(movie)
                .setTheaterRoom(theaterRoom)
                .build();

    }
}//end of class
