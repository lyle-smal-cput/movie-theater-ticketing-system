package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemServiceTest {

    @Autowired
    private ICartItemService service;
    private static Customer customer = CustomerFactory.createCustomer(
            "cust123", "customer", "password", "John", "Doe", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), CardFactory.createCard("1234567890123456", "12/25", "username"));
    private static Cart testCart = CartFactory.createCart("cart456", 1, customer);
    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("MO89","Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D", 150);
    public static Schedule schedule = ScheduleFactory.createSchedule("546", LocalTime.of(2, 23), LocalTime.of(3, 30), LocalDate.of(2025, 03, 16), false, movie, theaterRoom);
    private static final CartItem cartItem = CartItemFactory.createCartItem("item123", 3, testCart, schedule );

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
        var all = service.getAll();
        assertNotNull(all);
        assertFalse(all.isEmpty(), "Expected non-empty list of cart items");
        System.out.println("All items: " + all);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(cartItem.getCartItemId());
        assertTrue(success);
        System.out.println("Deleted: " + cartItem.getCartItemId());
    }
}
