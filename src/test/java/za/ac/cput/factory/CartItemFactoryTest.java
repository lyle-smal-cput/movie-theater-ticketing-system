package za.ac.cput.factory;
/* CartItemFactoryTest.java
     Cart Item Factory Test class
     Author: C Smith (221242597)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class CartItemFactoryTest {

    @Test
    void createCartItem() {
        House house = HouseFactory.createHouse("H236","23","Off Road","Athlone","Cape Town","South Africa",(short)7743);
        Customer customer=CustomerFactory.createCustomer("U124","SamFish","13422","Samuel","Fisher","Samfisher@gmail.com") Cart cart = CartFactory.createCart("cart123", 2, customer);
        Movie movie = MovieFactory.createMovie("Movie1","Example Movie", "Action", 120,"An action movie", 13, "Director Name", "2D");
        Branch branch = BranchFactory.createBranch("branch123", "Main Branch", "123 Main St", "City Center", "Johannesburg");
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("room123", 100, branch);
        Schedule schedule = ScheduleFactory.createSchedule("sched123", LocalTime.of(14, 0), LocalTime.of(16, 0), LocalDate.now(), false, movie, theaterRoom);


        CartItem cartItem = CartItemFactory.createCartItem("item123", 1, cart, schedule);

        assertNotNull(cartItem);


        System.out.println(cartItem);
    }
}
