/* TicketRepository.java
     Ticket Repository class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Ticket;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    Ticket findByTicketId(String ticketId);
    List<Ticket> findByUserId(String userId);
    List<Ticket> findByPaymentId(String paymentId);
    List<Ticket> findByScheduleId(String scheduleId);
    List<Ticket> findBySeatId(String seatId);
}
