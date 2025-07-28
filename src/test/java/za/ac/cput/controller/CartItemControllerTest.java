package za.ac.cput.controller;
/*   Author: C Smith (221242597)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartItemControllerTest {

    @Autowired
    private CartItemController controller;

    private static CartItem testCartItem;
    private static Customer customer = CustomerFactory.createCustomer(
            "cust123", "customer", "password", "John", "Doe", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), CardFactory.createCard("1234567890123456", "12/25", "username"));
    private static Cart testCart = CartFactory.createCart("cart456", 1, customer);
    private static Branch branch = BranchFactory.createBranch("Canal Walk", 10);
    private static TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("CW9", 9, 48, 10, false, branch);
    private static Movie movie = MovieFactory.createMovie("MO89","Venom", "Sci-Fi",  89, "The never ending adventure", 17, "Dragon Studio", "2D");
    public static Schedule schedule = ScheduleFactory.createSchedule("546", LocalTime.of(2, 23), LocalTime.of(3, 30), LocalDate.of(2025, 03, 16), false, movie, theaterRoom);


    @BeforeAll
    static void setUp() {


        testCartItem = CartItemFactory.createCartItem("item123", 3, testCart, schedule );
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
