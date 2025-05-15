package za.ac.cput.util;

/*
 Helper.java
 Helper class
 Author: LJ Smal (223236012)
     Date: 15 May 2025 */

import org.apache.commons.validator.routines.*;
import com.google.i18n.phonenumbers.*;

public class Helper {
private static EmailValidator emailValidator = EmailValidator.getInstance();
private static PhoneNumberUtil phoneNumberValidator = PhoneNumberUtil.getInstance();

    //Validate phone number
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (isNullOrEmpty(phoneNumber)) {
            return false;
        }
        try {
            Phonenumber.PhoneNumber number = phoneNumberValidator.parse(phoneNumber, "RSA");
            return phoneNumberValidator.isValidNumber(number);
        } catch (Exception e) {
            return false;
        }}

    //Validate email
     public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return emailValidator.isValid(email);
    }

    //Validate gender
    public static boolean isValidGender(String gender) {
        if (isNullOrEmpty(gender)) {
            return false;
        }

        if(gender.equals("male") || gender.equals("female")) {
           return true;

        }
        else{
            return false;
        }
    }

    //Validate if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
