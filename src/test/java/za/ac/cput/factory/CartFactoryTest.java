package za.ac.cput.factory;
/* CartFactoryTest.java
     Cart Factory Test Class
     Author: C Smith (221242597)
     Date: 16 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {
    Customer user = new Customer.Builder().setUserId("user1").build();
    Cart cart;

    @Test
    void createCart() {
        cart = CartFactory.createCart("cart1", 3, user);
        assertNotNull(cart);
        System.out.println(cart.toString());
    }
}