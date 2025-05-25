package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemServiceTest {

    @Autowired
    private ICartItemService service;

    private static final CartItem cartItem = CartItemFactory.createCartItem("CI1001", "Pizza", 3, 75.00);

    @Test
    void a_create() {
        CartItem created = service.create(cartItem);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        CartItem read = service.read(cartItem.getCartItemId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        CartItem updatedCartItem = new CartItem.Builder()
                .copy(cartItem)
                .setQuantity(5)
                .build();
        CartItem updated = service.update(updatedCartItem);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("All items: " + service.getAll());
    }
}
