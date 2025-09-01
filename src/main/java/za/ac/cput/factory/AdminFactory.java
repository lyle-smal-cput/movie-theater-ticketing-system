package za.ac.cput.factory;
/* AdminFactory.java
     Admin Factory class
     Author: LJ Smal (223236012)
     Date: 14 May 2025 */

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class AdminFactory {

    public static Admin createAdmin(String username, String password, String firstName,
                                    String lastName, String email, Address address, String cellphoneNumber, String gender, LocalDate dateOfBirth) {
        //Validates if userId, username, password, firstName, lastName, email, address, cellphone, gender, dateOfBirth is null or empty
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) ||
                address == null || Helper.isNullOrEmpty(cellphoneNumber) || Helper.isNullOrEmpty(gender) ){
            return null;
        }

        //Validates email, phone number & gender
        if(!Helper.isValidEmail(email) || !Helper.isValidPhoneNumber(cellphoneNumber) || !Helper.isValidGender(gender)){
            return null;
        }
        return new Admin.Builder()
                .setUsername(username)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddressId(address)
                .setCellphoneNumber(cellphoneNumber)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .setIsAdmin()
                .build();
    }
}
