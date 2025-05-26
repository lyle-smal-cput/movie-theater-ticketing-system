package za.ac.cput.factory;

/* CustomerFactory.java
     Customer Factory class
     Author: LJ Smal (223236012)
     Date: 14 May 2025 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class CustomerFactory {

    public static Customer createCustomer(String userId, String username, String password, String firstName,
                                          String lastName, String email, Address address, String cellphoneNumber, String gender, LocalDate dateOfBirth, Card card) {
        //Validates if userId, username, password, firstName, lastName, email, address, cellphone, gender, dateOfBirth and card is null or empty
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) ||
                address == null || Helper.isNullOrEmpty(cellphoneNumber) || Helper.isNullOrEmpty(gender)){
            return null;
        }

        //Validate email, phone number & gender
        if(!Helper.isValidEmail(email) || !Helper.isValidGender(gender)|| !Helper.isValidPhoneNumber(cellphoneNumber)){
            return null;
        }

        return new Customer.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setCellphoneNumber(cellphoneNumber)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .addCard(card)
                .build();
    }
}
