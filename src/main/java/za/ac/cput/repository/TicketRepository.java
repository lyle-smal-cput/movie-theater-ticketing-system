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
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findByTicketId(Long ticketId);
    List<Ticket> findByPaymentPaymentId(Long paymentId);  // if Payment entity has paymentId field

    List<Ticket> findByScheduleScheduleId(Long scheduleId);  // if Schedule entity has scheduleId field

    List<Ticket> findBySeatSeatId(Long seatId);
}
