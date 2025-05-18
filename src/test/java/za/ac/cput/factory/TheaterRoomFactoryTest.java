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