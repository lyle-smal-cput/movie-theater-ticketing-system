package za.ac.cput.factory;

import za.ac.cput.domain.Branch;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.util.Helper;

public class TheaterRoomFactory {
    public static TheaterRoom createTheaterRoom(String theaterRoomId, int roomNumber, int capacity, int seatsAvailable, boolean is3DSupported, Branch branch) {
        if (Helper.isNullOrEmpty(theaterRoomId)) {
            return null;
        }
        if (roomNumber <= 0) {
            return null;
        }
        if (capacity <= 0) {
            return null;
        }
        if (seatsAvailable < 0) {
            return null;
        }

        return new TheaterRoom.Builder()
                .setTheaterRoomId(theaterRoomId)
                .setRoomNumber(roomNumber)
                .setCapacity(capacity)
                .setSeatsAvailable(seatsAvailable)
                .setIs3DSupported(is3DSupported)
                .build();
    }
}
