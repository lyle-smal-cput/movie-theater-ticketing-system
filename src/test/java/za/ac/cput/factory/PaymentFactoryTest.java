package za.ac.cput.factory;
/* PaymentFactoryTest.java
     Payment Factory Test class
     Author: C Smith (221242597)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment() {
        Payment payment = PaymentFactory.createPayment("pay123", 100);
        assertNotNull(payment);
        assertEquals("pay123", payment.getPaymentId());
        assertEquals(100, payment.getAmount());

        System.out.println(payment);
    }


}
