package za.ac.cput.domain;

public class Seat {
    private String seatId;
    private int seatNumber;
    private boolean isAvailable;
    private TheaterRoom theaterRoom;

    protected Seat(){

    }

    private Seat(Builder builder) {
        this.seatId = builder.seatId;
        this.seatNumber = builder.seatNumber;
        this.isAvailable = builder.isAvailable;
        this.theaterRoom = builder.theaterRoom;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public TheaterRoom getTheaterRoom() {
        return theaterRoom;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatNumber=" + seatNumber +
                ", isAvailable=" + isAvailable +
                ", theaterRoom=" + theaterRoom +
                '}';
    }

    public static class Builder {
        private String seatId;
        private int seatNumber;
        private boolean isAvailable;
        private TheaterRoom theaterRoom;

        public Builder setSeatId(String seatId) {
            this.seatId = seatId;
            return this;
        }

        public Builder setSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Builder setTheaterRoom(TheaterRoom theaterRoom) {
            this.theaterRoom = theaterRoom;
            return this;
        }

        public Builder copy(Seat seat) {
            this.seatId = seat.seatId;
            this.seatNumber = seat.seatNumber;
            this.isAvailable = seat.isAvailable;
            this.theaterRoom = seat.theaterRoom;
            return this;
        }

        public Seat build() {
            return new Seat(this);
        }

    }
}
