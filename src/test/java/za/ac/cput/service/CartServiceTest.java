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

    private final Cart cart = CartFactory.createCart("C123", "User001");

    @Test
    void a_create() {
        Cart created = service.create(cart);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Cart read = service.read(cart.getCartId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Cart newCart = new Cart.Builder().copy(cart).setUserId("User002").build();
        Cart updated = service.update(newCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}
