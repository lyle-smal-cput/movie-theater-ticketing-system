package za.ac.cput.repository;
/* PaymentRepository.java
     Payment Repository class
     Author: C Smith (221242597)
     Date: 23 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByPaymentId(String paymentId);
    List<Payment> findByAmount(int amount);
}
