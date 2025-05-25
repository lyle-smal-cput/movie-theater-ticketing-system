package za.ac.cput.service;
/* IPaymentService.java
     IPayment Service class
     Author: C Smith (221242597)
     Date: 25 May 2025 */
import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment,String> {
    List<Payment>getAll();
}
