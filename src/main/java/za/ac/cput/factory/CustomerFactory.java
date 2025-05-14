package za.ac.cput.factory;

/* CustomerFactory.java
     Customer Factory class
     Author: LJ Smal (223236012)
     Date: 14 May 2025 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;

public class CustomerFactory {

    public static Customer createCustomer(String userId, String username, String password, String firstName,
                                          String lastName, String email, Address address, String cellphoneNumber, String gender, LocalDate dateOfBirth, Card card) {
        return new Customer.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setCellphoneNumber(cellphoneNumber)
                .build();
    }
}
