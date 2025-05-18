package za.ac.cput.factory;
/* CartFactoryTest.java
     Cart Factory Test class
     Author:C Smith (221242597)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

public class CartFactoryTest {
    @Test
    void createCart() {
        User user = UserFactory.createUser("U124", "SamFish", "13422", "Samuel", "Fisher", "samfisher@gmail.com", null, "0812345678", "Male", java.time.LocalDate.of(1990, 5, 10));

        Cart cart = CartFactory.createCart("cart001", 3, user);

        assertNotNull(cart);
        System.out.println(cart);
    }
}
