package za.ac.cput.factory;
  /* BranchFactoryTest.java
     Branch Factory Test POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Branch;

import static org.junit.jupiter.api.Assertions.*;

class BranchFactoryTest {
    @Test
    void createBranch() {
        Branch branch = BranchFactory.createBranch("Canal Walk, Century City", 12);
        assertNotNull(branch);
        assertEquals("Canal Walk, Century City", branch.getLocation());
        assertEquals(12, branch.getNumberOfTheaterRooms());
        assertNotNull(branch.getBranchId());
        System.out.println(branch);
    }

    @Test
    void createBranchWithNoTheaters() {
        Branch branch = BranchFactory.createBranch("Canal Walk, Century City", 0);
        assertNull(branch, "Branch with 0 theaters should be invalid");
    }

    @Test
    void createBranchWithNegativeTheaters() {
        Branch branch = BranchFactory.createBranch("Canal Walk, Century City", -1);
        assertNull(branch, "Branch with negative theaters should be invalid");
    }

    @Test
    void createBranchWithNullLocation() {
        Branch branch = BranchFactory.createBranch(null, 12);
        assertNull(branch, "Branch with null location should be invalid");
    }

    @Test
    void createBranchWithEmptyLocation() {
        Branch branch = BranchFactory.createBranch("", 12);
        assertNull(branch, "Branch with empty location should be invalid");
    }

}