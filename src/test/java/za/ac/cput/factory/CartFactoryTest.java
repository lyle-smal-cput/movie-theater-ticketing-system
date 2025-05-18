package za.ac.cput.factory;
/* CartFactoryTest.java
     Cart Factory Test class
     Author:C Smith (221242597)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CartFactoryTest {
    @Test
    void createCart() {
        LocalDate date = LocalDate.of(2024,12,03);
        House house = HouseFactory.createHouse("H342","Off Road","Athlone","Cape Town","South Africa",(short)7742);
        Card card = CardFactory.createCard("1234567890123456", "123", "Lyle Smal");
        Customer customer =CustomerFactory.createCustomer("cust123", "LukeMing", "1234","Luke","Ming","LukeMing@gmail.com",house,"0743648723","Male",date,card );

        Cart cart = CartFactory.createCart("cart001", 3, customer);

        assertNotNull(cart);
        System.out.println(cart);
    }
}
