package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CardFactory;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.HouseFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartControllerTest {

    @Autowired
    private CartController controller;

    private static Cart testCart;
    static LocalDate expiryDate = LocalDate.of(2025, 12, 31);
    private static Customer customer = CustomerFactory.createCustomer(
            "cust123", "customer", "password", "John", "Doe", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), CardFactory.createCard("1234567890123456", "12/25", "username", expiryDate));


    @BeforeAll
    static void setUp() {
        testCart = CartFactory.createCart("cart123", 2, customer);
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
