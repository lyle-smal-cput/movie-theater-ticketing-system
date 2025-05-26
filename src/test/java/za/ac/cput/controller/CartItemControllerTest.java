package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.User;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartItemControllerTest {

    @Autowired
    private CartItemController controller;

    private static CartItem testCartItem;
    private static Cart testCart;
    private static User testUser;

    @BeforeAll
    static void setUp() {
        testUser = UserFactory.createUser("user456", "Alice", "Smith", "alice@gmail.com");
        testCart = CartFactory.createCart("cart456", 1, testUser);
        testCartItem = CartItemFactory.createCartItem("item123", "Pizza Margherita", 3, testCart);
    }

    @Test
    @Order(1)
    void create() {
        CartItem created = controller.create(testCartItem);
        assertNotNull(created);
        assertEquals(testCartItem.getCartItemId(), created.getCartItemId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        CartItem read = controller.read(testCartItem.getCartItemId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        CartItem updated = new CartItem.Builder()
                .copy(testCartItem)
                .setQuantity(5)
                .build();
        CartItem result = controller.update(updated);
        assertNotNull(result);
        assertEquals(5, result.getQuantity());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        var all = controller.getAll();
        assertFalse(all.isEmpty());
        System.out.println("GetAll: " + all.size() + " cart items");
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = controller.delete(testCartItem.getCartItemId());
        assertTrue(success);
        System.out.println("Deleted: " + testCartItem.getCartItemId());
    }
}
