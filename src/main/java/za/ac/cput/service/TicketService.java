/* TicketService.java
     Ticket Service class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Ticket;
import za.ac.cput.repository.TicketRepository;

import java.util.List;
@Service
public class TicketService implements ITicketService{
    private ITicketService service;
    @Autowired
    private TicketRepository repository;

    @Override
    public Ticket create(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public Ticket read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Ticket> getAll() {
        return this.repository.findAll();
    }
}
