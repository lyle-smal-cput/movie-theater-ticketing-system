package za.ac.cput.domain;

public class TheaterRoom {
    private String theaterRoomId;
    private int roomNumber;
    private int capacity;
    private int seatsAvailable;
    private boolean is3DSupported;
    private Branch branch;

    protected TheaterRoom() {
    }

    private TheaterRoom(Builder builder) {
        this.theaterRoomId = builder.theaterRoomId;
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
        this.seatsAvailable = builder.seatsAvailable;
        this.is3DSupported = builder.is3DSupported;
        this.branch = builder.branch;
    }

    public String getTheaterRoomId() {
        return theaterRoomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public boolean isIs3DSupported() {
        return is3DSupported;
    }

    public Branch getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "TheaterRoom{" +
                "theaterRoomId='" + theaterRoomId + '\'' +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", seatsAvailable=" + seatsAvailable +
                ", is3DSupported=" + is3DSupported +
                ", branch=" + branch +
                '}';
    }

    public static class Builder {
        private String theaterRoomId;
        private int roomNumber;
        private int capacity;
        private int seatsAvailable;
        private boolean is3DSupported;
        private Branch branch;

        public Builder setTheaterRoomId(String theaterRoomId) {
            this.theaterRoomId = theaterRoomId;
            return this;
        }

        public Builder setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setSeatsAvailable(int seatsAvailable) {
            this.seatsAvailable = seatsAvailable;
            return this;
        }

        public Builder set3DSupported(boolean is3DSupported) {
            this.is3DSupported = is3DSupported;
            return this;
        }

        public Builder setBranch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Builder copy(TheaterRoom theaterRoom) {
            this.theaterRoomId = theaterRoom.theaterRoomId;
            this.roomNumber = theaterRoom.roomNumber;
            this.capacity = theaterRoom.capacity;
            this.seatsAvailable = theaterRoom.seatsAvailable;
            this.is3DSupported = theaterRoom.is3DSupported;
            this.branch = theaterRoom.branch;
            return this;
        }

        public TheaterRoom build() {
            return new TheaterRoom(this);
        }
    }
}
