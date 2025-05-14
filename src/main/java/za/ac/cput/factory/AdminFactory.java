package za.ac.cput.factory;
/* AdminFactory.java
     Admin Factory class
     Author: LJ Smal (223236012)
     Date: 14 May 2025 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;

import java.time.LocalDate;

public class AdminFactory {

    public static Admin createAdmin(String userId, String username, String password, String firstName,
                                    String lastName, String email, Address address, String cellphoneNumber, String gender, LocalDate dateOfBirth) {
        return new Admin.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddressId(address)
                .setCellphoneNumber(cellphoneNumber)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .build();
    }
}
