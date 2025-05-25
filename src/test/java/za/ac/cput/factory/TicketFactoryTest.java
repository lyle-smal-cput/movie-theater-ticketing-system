/* TicketFactoryTest.java
     TicketFactoryTest class
     Author: S Rawoot (221075127)
     Date: 18 May 2025 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.security.PKCS12Attribute;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void createTicket() {
        LocalDate date = LocalDate.of(2023, 10, 10);
        House house = HouseFactory.createHouse("H123", "12", "Main Road", "Athlone", "Cape Town", (short) 7764);
        Card card = CardFactory.createCard("C123", "774", "1234567890123456");
        Customer customer = CustomerFactory.createCustomer("U123", "John Doe", "222", "John",
                "Doe", "jdoe@gmail.com", house, "0795003139", "Male", date, card);
        Payment payment = PaymentFactory.createPayment("P123", 200);
        LocalTime startTime = LocalTime.of(12, 0);
        LocalTime endTime = LocalTime.of(14, 0);
        Movie movie = MovieFactory.createMovie("M123", "Inception", "Sci-Fi", 148, "Christopher Nolan", 2010, "Warner Bros", "PG-13");
        Branch branch = BranchFactory.createBranch("Kenilworth",10);
        TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
        Schedule schedule = ScheduleFactory.createSchedule("S123", startTime, endTime, date, false, movie, theaterRoom);
        Seat seat = SeatFactory.createSeat("S123", 1, true, theaterRoom);
        Ticket ticket = TicketFactory.createTicket("123", customer, payment, schedule, seat);
        assertNotNull(ticket);
        System.out.println(ticket);
    }
}