package za.ac.cput.domain;

/* Customer.java
     Customer POJO class
     Author: LJ Smal (223236012)
     Date: 11 May 2025 */

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")  // foreign key column in card table referencing Customer
    private List<Card> cards;

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
        this.cards = builder.cards;
        this.isAdmin = builder.isAdmin;
    }

    protected Customer() {

    }

    public Long getUserId() {
        return userId;
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
                ", card=" + cards + "\'";
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
        private List<Card> cards = new ArrayList<>();
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

        public Builder addCard(Card card) {
            this.cards.add(card);
            return this;
        }

        public Builder setIsAdmin() {
            this.isAdmin = false;
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
            this.cards = customer.cards;
            this.isAdmin = false;
            return this;
        }
    }

}
