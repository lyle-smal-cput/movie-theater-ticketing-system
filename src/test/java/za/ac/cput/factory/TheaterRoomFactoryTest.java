/* TheaterRoomFactoryTest.java
     TheaterRoomFactoryTest class
     Author: S Rawoot (221075127)
     Date: 18 May 2025 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.TheaterRoom;

import static org.junit.jupiter.api.Assertions.*;

class TheaterRoomFactoryTest {

    @Test
    void createTheaterRoom() {
        Branch branch = BranchFactory.createBranch("Kenilworth", 10);
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
        assertNotNull(theaterRoom);
        System.out.println(theaterRoom);
    }
}