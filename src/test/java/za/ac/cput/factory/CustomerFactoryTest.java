package za.ac.cput.factory;
/* CustomerFactoryTest.java
     Customer Factory Test class
     Author: LJ Smal (223236012)
     Date: 18 May 2025 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.House;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    House address = HouseFactory.createHouse("123456789", "Main Street", "28", "Cape Town", "South Africa", (short) 8000);
    Card card = CardFactory.createCard("1234567890123456", "123", "Lyle Smal");
    Customer customer;

    @Test
    void createCustomer() {
        customer = CustomerFactory.createCustomer("223236012", "lylesmal", "12345678", "Lyle", "Smal", "lylesmal@gmail.com", address, "+2782123456", "male", LocalDate.of(2004, 1, 26), card);
        assertNotNull(customer);
        System.out.println(customer.toString());
    }
}