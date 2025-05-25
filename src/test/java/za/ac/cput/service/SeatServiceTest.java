/* SeatServiceTest.java
     Seat Service Test class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Seat;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.factory.SeatFactory;
import za.ac.cput.factory.TheaterRoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SeatServiceTest {
    @Autowired
    private ISeatService service;

    Branch branch = BranchFactory.createBranch("Kenilworth", 10);
    TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
    Seat seat = SeatFactory.createSeat("S123", 1, true, theaterRoom);

    @Test
    void a_create() {
        Seat created = service.create(seat);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Seat read = service.read(seat.getSeatId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Seat updatedSeat = new Seat.Builder().copy(seat).setSeatNumber(2).build();
        Seat updated = service.update(updatedSeat);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_getAll() {
        assertFalse(service.getAll().isEmpty());
        System.out.println(service.getAll());
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(seat.getSeatId());
        assertTrue(deleted);
        System.out.println("Seat deleted successfully");
    }
}