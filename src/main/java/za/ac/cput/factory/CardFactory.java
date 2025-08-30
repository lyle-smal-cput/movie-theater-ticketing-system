package za.ac.cput.factory;

import za.ac.cput.domain.Card;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/* CardFactory.java
    Card Factory class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */

public class CardFactory {

    public static Card createCard(String cardNumber, String cvv, String cardHolder, LocalDate expiryDate){
        if(Helper.isValidCVV(cvv) || Helper.isNullOrEmpty(cvv)){
            return null;
        }
        if(Helper.isValidCardNumber(cardHolder)){
            return null;
        }
        if(Helper.isNullOrEmpty(cardHolder) || Helper.isNullOrEmpty(cardNumber) ){
            return null;
        }
              return new Card.CardBuilder()
                      .setCardNumber(cardNumber)
                      .setCvv(cvv)
                      .setCardHolderName(cardHolder)
                      .setExpiryDate(expiryDate)
                      .build();


    }
}//end of class
