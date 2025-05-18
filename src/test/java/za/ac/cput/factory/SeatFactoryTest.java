/* SeatFactoryTest.java
     SeatFactoryTest class
     Author: S Rawoot (221075127)
     Date: 18 May 2025 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Seat;
import za.ac.cput.domain.TheaterRoom;

import static org.junit.jupiter.api.Assertions.*;

class SeatFactoryTest {

    @Test
    void createSeat() {
        Branch branch = BranchFactory.createBranch("Kenilworth", 10);
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
        Seat seat = SeatFactory.createSeat("S123", 1, true, theaterRoom);
        assertNotNull(seat);
        System.out.println(seat);
    }
}