/* SeatFactory.java
     SeatFactory class
     Author: S Rawoot (221075127)
     Date: 18 May 2025 */
package za.ac.cput.factory;

import za.ac.cput.domain.Seat;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.util.Helper;

public class SeatFactory {
    public static Seat createSeat(String seatId, int seatNumber, boolean isAvailable, TheaterRoom theaterRoom) {

        if (Helper.isNullOrEmpty(seatId)) {
            return null;
        }

        if (seatNumber <= 0) {
            return null;
        }

        return new Seat.Builder()
                .setSeatId(seatId)
                .setSeatNumber(seatNumber)
                .setAvailable(isAvailable)
                .setTheaterRoom(theaterRoom)
                .build();
    }
}
