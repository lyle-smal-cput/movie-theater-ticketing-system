package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Branch;
import za.ac.cput.factory.BranchFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BranchServiceTest {
    @Autowired
    private BranchService service;

    private Branch branch = BranchFactory.createBranch("Canal Walk", 12);

    @Test
    void create() {
        Branch created = service.create(branch);
        assertNotNull(created);
        assertEquals(branch.getBranchId(), created.getBranchId());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Branch read = service.read(branch.getBranchId());
        assertNotNull(read);
        assertEquals(branch.getBranchId(), read.getBranchId());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Branch updated = new Branch.Builder().copy(branch).setNumberOfTheaterRooms(14).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(branch.getBranchId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll() {
        service.create(branch);
        List<Branch> branches = service.getAll();
        assertNotNull(branches);
        assertTrue(branches.size() > 0);
        System.out.println("All branches: " + branches.size());
    }
}