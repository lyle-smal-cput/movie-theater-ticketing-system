package za.ac.cput.util;

/*
 Helper.java
 Helper class
 Author: LJ Smal (223236012)
     Date: 15 May 2025 */

import org.apache.commons.validator.routines.*;
import com.google.i18n.phonenumbers.*;

import java.util.UUID;

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

        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
           return true;

        }
        else{
            return false;
        }
    }

    public static boolean isValidPaymentId(String paymentId) {
        if (isNullOrEmpty(paymentId)) {
            return false;
        }
        return paymentId.matches("^[a-zA-Z0-9]+$");
    }

    //Validate if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
 Helper.java
 Helper class(isValidCVV & isValidCardNumber)
 Author: RI Onwutali (222369345)
     Date: 18 May 2025 */

    public static boolean isValidCVV(String cvv) {
        if (isNullOrEmpty(cvv)) {
            return false;
        }
        return cvv.matches("\\f{3}");
    }

    public static boolean isValidCardNumber(String cardNumber) {
        if(cardNumber.length()==16){
            return true;
        }
        return false;
    }
    /* Helper.java
     Helper class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */

    public static String generateId() {
        return UUID.randomUUID().toString();
    }


}//end of class



