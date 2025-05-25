/* TicketController.java
     Ticket Controller class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Ticket;
import za.ac.cput.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
    private TicketService service;

    @Autowired
    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket) {
        return service.create(ticket);
    }

    @GetMapping("/read/{ticketId}")
    public Ticket read(@PathVariable String ticketId) {
        return service.read(ticketId);
    }

    @PutMapping("/update")
    public Ticket update(@RequestBody Ticket ticket) {
        return service.update(ticket);
    }

    @DeleteMapping("/delete/{ticketId}")
    public boolean delete(@PathVariable String ticketId) {
        return service.delete(ticketId);
    }

    @GetMapping("/getAll")
    public List<Ticket> getAll() {
        return service.getAll();
    }
}
