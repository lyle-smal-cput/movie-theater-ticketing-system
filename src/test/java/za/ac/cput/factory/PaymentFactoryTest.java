package za.ac.cput.factory;
/* PaymentFactoryTest.java
     Payment Factory Test Class
     Author: C Smith (221242597)
     Date: 16 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {
    Payment payment;

    @Test
    void createPayment() {
        payment = PaymentFactory.createPayment("pay123", 100);
        assertNotNull(payment);
        System.out.println(payment.toString());
    }
}