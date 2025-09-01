package za.ac.cput.domain;

/* User.java
     User POJO class
     Author: LJ Smal (223236012)
     Date: 11 May 2025 */

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public abstract class User {
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    protected Address address;
    protected String cellphoneNumber;
    protected String gender;
    protected LocalDate dateOfBirth;

    protected boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddressId() {
        return address;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
