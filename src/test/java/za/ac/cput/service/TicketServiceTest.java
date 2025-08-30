/* TicketServiceTest.java
     Ticket Service Test class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

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
class TicketServiceTest {
    @Autowired
    private ITicketService service;

    LocalDate date = LocalDate.of(2023, 10, 10);
    House house = HouseFactory.createHouse("H123", "12", "Main Road", "Athlone", "Cape Town", (short) 7764);
    Card card = CardFactory.createCard("C123", "774", "1234567890123456", date);
    Customer customer = CustomerFactory.createCustomer("U123", "John Doe", "222", "John",
            "Doe", "jdoe@gmail.com", house, "0795003139", "Male", date, card);
    Payment payment = PaymentFactory.createPayment("P123", 200);
    LocalTime startTime = LocalTime.of(12, 0);
    LocalTime endTime = LocalTime.of(14, 0);
    Movie movie = MovieFactory.createMovie("M123", "Inception", 60, "148", 16, "2010", "Warner Bros", 160, null);
    Branch branch = BranchFactory.createBranch("Kenilworth",10);
    TheaterRoom theaterRoom = TheaterRoomFactory.createTheaterRoom("TR123", 10, 100, 50, true, branch);
    Schedule schedule = ScheduleFactory.createSchedule(startTime, startTime, date, false, movie, theaterRoom);
    Seat seat = SeatFactory.createSeat("S123", 1, true, theaterRoom);
    Ticket ticket = TicketFactory.createTicket("123", customer, payment, schedule, seat);

    @Test
    void a_create() {
        Ticket created = service.create(ticket);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Ticket read = service.read(ticket.getTicketId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Ticket newTicket = new Ticket.Builder().copy(ticket).setTicketId("124").build();
        Ticket updated = service.update(newTicket);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        assertFalse(service.getAll().isEmpty());
        System.out.println(service.getAll());
    }

    @Test
    void e_delete() {
        boolean deleted = service.delete(ticket.getTicketId());
        assertTrue(deleted);
        System.out.println("Ticket deleted successfully");
    }
}