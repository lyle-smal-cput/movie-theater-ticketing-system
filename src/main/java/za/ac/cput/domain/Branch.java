package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/* Branch.java
     Branch POJO class
     Author: S Rasmeni (222906073)
     Date: 11 May 2025 */
@Entity
public class Branch {
    @Id
    private String branchId;
    private String location;
    private int numberOfTheaterRooms;

    public Branch() {
    }

    public Branch(String branchId, int numberOfTheaterRooms) {
        this.branchId = branchId;
        this.numberOfTheaterRooms = numberOfTheaterRooms;
    }

    private Branch(Builder builder) {
        this.branchId = builder.branchId;
        this.location = builder.location;
        this.numberOfTheaterRooms = builder.numberOfTheaterRooms;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfTheaterRooms() {
        return numberOfTheaterRooms;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", location='" + location + '\'' +
                ", numberOfTheaterRooms=" + numberOfTheaterRooms +
                '}';
    }

    public static class Builder {
        private String branchId;
        private String location;
        private int numberOfTheaterRooms;

        public Builder setBranchId(String branchId) {
            this.branchId = branchId;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setNumberOfTheaterRooms(int numberOfTheaterRooms) {
            this.numberOfTheaterRooms = numberOfTheaterRooms;
            return this;
        }
        public Branch.Builder copy(Branch branch) {
            this.branchId = branch.branchId;
            this.numberOfTheaterRooms = branch.numberOfTheaterRooms;
            return this;
        }
        public Branch build() {
            return new Branch(this);
        }
    }
}
