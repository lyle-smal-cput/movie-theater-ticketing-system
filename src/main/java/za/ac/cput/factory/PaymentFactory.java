package za.ac.cput.factory;
/* PaymentFactory.java
     Payment Factory class
     Author: C Smith (221242597)
     Date: 16 May 2025 */

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment createPayment(String paymentId, int amount) {
        // Validates if paymentId is null or empty
        if (Helper.isNullOrEmpty(paymentId) || Helper.isValidPaymentId(paymentId) || amount <= 0) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setAmount(amount)
                .build();
    }
}
