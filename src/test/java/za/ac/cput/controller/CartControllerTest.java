package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.User;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartControllerTest {

    @Autowired
    private CartController controller;

    private static Cart testCart;
    private static User testUser;

    @BeforeAll
    static void setUp() {
        testUser = UserFactory.createUser("user123", "John", "Doe", "john@example.com");
        testCart = CartFactory.createCart("cart123", 2, testUser);
    }

    @Test
    @Order(1)
    void create() {
        Cart created = controller.create(testCart);
        assertNotNull(created);
        assertEquals(testCart.getCartId(), created.getCartId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Cart read = controller.read(testCart.getCartId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Cart updated = new Cart.Builder()
                .copy(testCart)
                .setQuantity(5)
                .build();
        Cart result = controller.update(updated);
        assertNotNull(result);
        assertEquals(5, result.getQuantity());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        var all = controller.getAll();
        assertFalse(all.isEmpty());
        System.out.println("GetAll: " + all.size() + " carts");
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = controller.delete(testCart.getCartId());
        assertTrue(success);
        System.out.println("Deleted: " + testCart.getCartId());
    }
}
