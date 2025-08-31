/* ITicketService.java
     ITicket Service Interface
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import za.ac.cput.domain.Ticket;

import java.util.List;

public interface ITicketService extends IService<Ticket, Long> {
    List<Ticket> getAll();
}
