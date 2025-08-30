package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CardFactory;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.HouseFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceTest {

    @Autowired
    private ICartService service;
    static LocalDate expiryDate = LocalDate.of(2025, 12, 31);
    private static Customer customer = CustomerFactory.createCustomer(
            "cust123", "customer", "password", "John", "Doe", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), CardFactory.createCard("1234567890123456", "12/25", "username", expiryDate));


    private static final Cart cart = CartFactory.createCart("cart123", 2, customer);

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
                .setUser(customer)
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
