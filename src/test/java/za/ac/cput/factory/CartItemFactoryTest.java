package za.ac.cput.factory;
/* CartItemFactoryTest.java
     Cart Item Factory Test Class
     Author: C Smith (221242597)
     Date: 16 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Schedule;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {
    Customer user = new Customer.Builder().setUserId("user1").build();
    Cart cart = new Cart.Builder().setCartId("cart1").setQuantity(2).setUser(user).build();
    Schedule schedule = new Schedule.Builder().setScheduleId("sched1").build();
    CartItem cartItem;

    @Test
    void createCartItem() {
        cartItem = CartItemFactory.createCartItem("item1", 1, cart, schedule);
        assertNotNull(cartItem);
        System.out.println(cartItem.toString());
    }
}