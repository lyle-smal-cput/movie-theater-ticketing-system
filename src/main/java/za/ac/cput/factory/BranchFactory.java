package za.ac.cput.factory;
/* BranchFactory.java
     Branch Factory POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import za.ac.cput.domain.Branch;
import za.ac.cput.util.Helper;

public class BranchFactory {
    public static Branch createBranch(String location, int numberOfTheaterRooms) {
        if (Helper.isNullOrEmpty(location) || numberOfTheaterRooms <= 0) {
            return null;
        }

        String branchId = Helper.generateId();

        return new Branch.Builder()
                .setBranchId(branchId)
                .setLocation(location)
                .setNumberOfTheaterRooms(numberOfTheaterRooms)
                .build();
    }
}

