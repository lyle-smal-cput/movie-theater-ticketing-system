package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/* Admin.java
     Admin POJO class
     Author: LJ Smal (223236012)
     Date: 11 May 2025 */
@Entity
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    private Admin(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.cellphoneNumber = builder.cellphoneNumber;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.isAdmin = builder.isAdmin;
    }

    protected Admin() {

    }

    public Long getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth + '\'' ;
    }

    public static class Builder {
        private Long userId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Address address;
        private String cellphoneNumber;
        private String gender;
        private LocalDate dateOfBirth;
        private boolean isAdmin;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddressId(Address address) {
            this.address = address;
            return this;
        }

        public Builder setCellphoneNumber(String cellphoneNumber) {
            this.cellphoneNumber = cellphoneNumber;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder copy(Admin admin) {
            this.userId = admin.userId;
            this.username = admin.username;
            this.password = admin.password;
            this.firstName = admin.firstName;
            this.lastName = admin.lastName;
            this.email = admin.email;
            this.address = admin.address;
            this.cellphoneNumber = admin.cellphoneNumber;
            this.gender = admin.gender;
            this.dateOfBirth = admin.dateOfBirth;
            this.isAdmin = admin.isAdmin;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
