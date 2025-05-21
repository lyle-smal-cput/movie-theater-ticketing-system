package za.ac.cput.domain;

/* Customer.java
     Customer POJO class
     Author: LJ Smal (223236012)
     Date: 11 May 2025 */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;

@Entity
public class Customer extends User {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number")
    private Card card;

    private Customer(Builder builder) {
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
        this.card = builder.card;
    }

    protected Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", card=" + card + "\'";
    }

    public static class Builder {
        private String userId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Address address;
        private String cellphoneNumber;
        private String gender;
        private LocalDate dateOfBirth;
        private Card card;

        public Builder setUserId(String userId) {
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

        public Builder setAddress(Address address) {
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

        public Builder setCard(Card card) {
            this.card = card;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

        public Builder copy(Customer customer) {
            this.userId = customer.userId;
            this.username = customer.username;
            this.password = customer.password;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.address = customer.address;
            this.cellphoneNumber = customer.cellphoneNumber;
            this.gender = customer.gender;
            this.dateOfBirth = customer.dateOfBirth;
            this.card = customer.card;
            return this;
        }
    }

}
