/* TheaterRoomServiceTest.java
     Theater Room Service Test class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.factory.TheaterRoomFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TheaterRoomServiceTest {
    @Autowired
    private ITheaterRoomService service;

    Branch branch = BranchFactory.createBranch("Kenilworth", 10);
    TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);

    @Test
    void a_create() {
        TheaterRoom created = service.create(theaterRoom);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        TheaterRoom read = service.read(theaterRoom.getTheaterRoomId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        TheaterRoom updatedTheaterRoom = new TheaterRoom.Builder().copy(theaterRoom).setCapacity(120).build();
        TheaterRoom updated = service.update(updatedTheaterRoom);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
        System.out.println(service.getAll());
    }

    @Test
    void e_delete() {
        boolean deleted = service.delete(theaterRoom.getTheaterRoomId());
        assertTrue(deleted);
        System.out.println("Theater Room deleted successfully");
    }
}