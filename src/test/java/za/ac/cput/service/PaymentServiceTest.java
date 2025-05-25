package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private IPaymentService service;

    private final Payment payment = PaymentFactory.createPayment("P101", "CreditCard", 200.00);

    @Test
    void a_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Payment read = service.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Payment newPayment = new Payment.Builder().copy(payment).setAmount(250.00).build();
        Payment updated = service.update(newPayment);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}
