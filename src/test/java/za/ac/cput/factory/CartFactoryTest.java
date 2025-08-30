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
        Card card = CardFactory.createCard("1234567890123456", "123", "Lyle Smal", date);
        Customer customer =CustomerFactory.createCustomer("223236012", "lylesmal", "12345678", "Lyle", "Smal", "lylesmal@gmail.com", house, "+2782123456", "male", LocalDate.of(2004, 1, 26), card);

        Cart cart = CartFactory.createCart("cart001", 3, customer);

        assertNotNull(cart);
        System.out.println(cart);
    }
}
