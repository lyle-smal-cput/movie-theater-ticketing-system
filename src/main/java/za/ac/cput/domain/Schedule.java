package za.ac.cput.domain;
/* Schedule.java
     Schedule POJO class
     Author: RI Onwutali (222369345)
     Date: 11 May 2025 */

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String scheduleId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private boolean isFinishedAiring;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id")
    private  Movie movie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "theater_id")
    private TheaterRoom theaterRoom;

    public Schedule() {

    }//end of Schedule()

    public Schedule(ScheduleBuilder builder){
        this.scheduleId = builder.scheduleId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.date = builder.date;
        this.isFinishedAiring = builder.isFinishedAiring;
        this.movie = builder.movie;
        this.theaterRoom = builder.theaterRoom;
    }//end of Schedule(ScheduleBuilder)

    public String getScheduleId() {
        return scheduleId;
    }
    public String getStartTime() {
        return startTime.toString();
    }
    public String getEndTime() {
        return endTime.toString();
    }
    public String getDate() {
        return date.toString();
    }
    public boolean isFinishedAiring() {
        return isFinishedAiring;
    }
    public Movie getMovie() {
        return movie;
    }

    public TheaterRoom getTheaterRoom() {
        return theaterRoom;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId: '" + scheduleId + '\'' +
                ", startTime: " + startTime +
                ", endTime: " + endTime +
                ", date: " + date +
                ", isFinishedAiring: " + isFinishedAiring +
                ", movie: " + movie +
                ", theaterRoom: " + theaterRoom +
                '}';
    }//end of toString()

    public static class ScheduleBuilder {
        private String scheduleId;
        private LocalTime startTime;
        private LocalTime endTime;
        private LocalDate date;
        private boolean isFinishedAiring;
        private Movie movie;
        private TheaterRoom theaterRoom;

        public ScheduleBuilder(){

        }

        public ScheduleBuilder(String scheduleId, LocalTime startTime, LocalTime endTime,
                               LocalDate date, boolean isFinishedAiring, Movie movie, TheaterRoom theaterRoom) {
            this.scheduleId = scheduleId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.date = date;
            this.isFinishedAiring = isFinishedAiring;
            this.movie = movie;
            this.theaterRoom = theaterRoom;
        }

        public ScheduleBuilder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }
        public ScheduleBuilder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }
        public ScheduleBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public ScheduleBuilder setIsFinishedAiring(boolean isFinishedAiring) {
            this.isFinishedAiring = isFinishedAiring;
            return this;
        }
        public ScheduleBuilder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }
        public ScheduleBuilder setTheaterRoom(TheaterRoom theaterRoom) {
            this.theaterRoom = theaterRoom;
            return this;
        }
        public ScheduleBuilder copy(Schedule schedule) {
            this.scheduleId = schedule.scheduleId;
            this.startTime = schedule.startTime;
            this.endTime = schedule.endTime;
            this.date = schedule.date;
            this.isFinishedAiring = schedule.isFinishedAiring;
            this.movie = schedule.movie;
            this.theaterRoom = schedule.theaterRoom;
            return this;
        }

        public Schedule build() {
            return new Schedule(this);

        }
    }//end of static class
}// end of class
