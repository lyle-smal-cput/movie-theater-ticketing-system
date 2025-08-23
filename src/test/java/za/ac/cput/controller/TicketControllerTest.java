/* TicketControllerTest.java
     Ticket Controller Test class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TicketControllerTest {
    private final TicketController controller;

    LocalDate date = LocalDate.of(2023, 10, 10);
    House house = HouseFactory.createHouse("H123", "12", "Main Road", "Athlone", "Cape Town", (short) 7764);
    Card card = CardFactory.createCard("C123", "774", "1234567890123456");
    Customer customer = CustomerFactory.createCustomer("U123", "John Doe", "222", "John",
            "Doe", "jdoe@gmail.com", house, "0795003139", "Male", date, card);
    Payment payment = PaymentFactory.createPayment("P123", 200);
    LocalTime startTime = LocalTime.of(12, 0);
    LocalTime endTime = LocalTime.of(14, 0);
    Movie movie = MovieFactory.createMovie("M123", "Inception", "Sci-Fi", 148, "Christopher Nolan", 2010, "Warner Bros", "PG-13", 150);
    Branch branch = BranchFactory.createBranch("Kenilworth",10);
    TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
    Schedule schedule = ScheduleFactory.createSchedule("S123", startTime, endTime, date, false, movie, theaterRoom);
    Seat seat = SeatFactory.createSeat("S123", 1, true, theaterRoom);
    Ticket ticket = TicketFactory.createTicket("123", customer, payment, schedule, seat);

    @Autowired
    TicketControllerTest(TicketController controller) {
        this.controller = controller;
    }

    @Test
    void a_create() {
        Ticket created = controller.create(ticket);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Ticket read = controller.read(ticket.getTicketId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Ticket newTicket = new Ticket.Builder().copy(ticket).setTicketId("124").build();
        Ticket updated = controller.update(newTicket);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        assertFalse(controller.getAll().isEmpty());
        System.out.println(controller.getAll());
    }

    @Test
    void e_delete() {
        boolean deleted = controller.delete(ticket.getTicketId());
        assertTrue(deleted);
        System.out.println("Ticket deleted successfully");
    }
}