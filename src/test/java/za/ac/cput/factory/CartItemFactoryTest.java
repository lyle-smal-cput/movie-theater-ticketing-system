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
        LocalDate date = LocalDate.of(2024,12,03);
        House house = HouseFactory.createHouse("H342","Off Road","Athlone","Cape Town","South Africa",(short)7742);
        Card card = new Card.CardBuilder().setCardNumber("1234567890123456").setCvv("123").setCardHolderName("JohnDoe").build();
        Customer customer =CustomerFactory.createCustomer("223236012", "lylesmal", "12345678", "Lyle", "Smal", "lylesmal@gmail.com", house, "+2782123456", "male", LocalDate.of(2004, 1, 26), card);
        Cart cart = CartFactory.createCart("cart123", 2, customer);
        Movie movie = MovieFactory.createMovie("Movie1","Example Movie", "Action", 120,"An action movie", 13, "Director Name", "2D");
        Branch branch = BranchFactory.createBranch("Cape Town", 5);
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
        LocalTime startTime = LocalTime.of(12,0);
        LocalTime endTime = LocalTime.of(14,0);
        Schedule schedule = ScheduleFactory.createSchedule("sched123",startTime,endTime, date, false, movie, theaterRoom);


        CartItem cartItem = CartItemFactory.createCartItem("item123", 1, cart, schedule);

        assertNotNull(cartItem);


        System.out.println(cartItem);
    }
}
