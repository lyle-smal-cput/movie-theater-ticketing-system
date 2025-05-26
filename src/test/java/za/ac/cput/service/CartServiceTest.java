package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceTest {

    @Autowired
    private ICartService service;

    private static final Cart cart = CartFactory.createCart("C123", "User001");

    @Test
    void a_create() {
        Cart created = service.create(cart);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Cart read = service.read(cart.getCartId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Cart newCart = new Cart.Builder()
                .copy(cart)
                .setUserId("User002")
                .build();
        Cart updated = service.update(newCart);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        var carts = service.getAll();
        assertNotNull(carts);
        assertFalse(carts.isEmpty(), "Expected non-empty list of carts");
        System.out.println("All carts: " + carts);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(cart.getCartId());
        assertTrue(success);
        System.out.println("Deleted: " + cart.getCartId());
    }
}
