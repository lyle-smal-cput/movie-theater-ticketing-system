package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTest {

    @Autowired
    private PaymentController controller;

    private static Payment testPayment;
    private static final String INVALID_ID = "INVALID_ID";

    @BeforeAll
    static void setUp() {
        testPayment = PaymentFactory.createPayment(
                "pay123",
                "order123",
                999.99,
                "CREDIT_CARD",
                LocalDateTime.now(),
                "COMPLETED"
        );
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
                .setStatus("REFUNDED")
                .build();
        assertNotNull(controller.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = controller.delete(testPayment.getPaymentId());
        assertTrue(success);
        System.out.println("Deleted: " + testPayment.getPaymentId());
    }

    @Test
    @Order(5)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
        System.out.println("GetAll: " + controller.getAll().size() + " payments");
    }

}