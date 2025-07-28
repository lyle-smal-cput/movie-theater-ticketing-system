package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTest {

    @Autowired
    private PaymentController controller;

    private static Payment testPayment;

    @BeforeAll
    static void setUp() {
        testPayment = PaymentFactory.createPayment("pay123", 199);
    }

    @Test
    @Order(1)
    void create() {
        Payment created = controller.create(testPayment);
        assertNotNull(created);
        assertEquals(testPayment.getPaymentId(), created.getPaymentId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Payment read = controller.read(testPayment.getPaymentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Payment updated = new Payment.Builder()
                .copy(testPayment)
                .setAmount(249)
                .build();
        Payment result = controller.update(updated);
        assertNotNull(result);
        assertEquals(249, result.getAmount());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        var all = controller.getAll();
        assertFalse(all.isEmpty());
        System.out.println("GetAll: " + all.size() + " payments");
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = controller.delete(testPayment.getPaymentId());
        assertTrue(success);
        System.out.println("Deleted: " + testPayment.getPaymentId());
    }
}
