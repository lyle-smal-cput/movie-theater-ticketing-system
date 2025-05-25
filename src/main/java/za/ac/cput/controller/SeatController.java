/* SeatController.java
     Seat Controller class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Seat;
import za.ac.cput.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    private SeatService service;

    @Autowired
    public SeatController(SeatService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Seat create(@RequestBody Seat seat) {
        return service.create(seat);
    }

    @GetMapping("/read/{seatId}")
    public Seat read(@PathVariable String seatId) {
        return service.read(seatId);
    }

    @PutMapping("/update")
    public Seat update(@RequestBody Seat seat) {
        return service.update(seat);
    }

    @DeleteMapping("/delete/{seatId}")
    public boolean delete(@PathVariable String seatId) {
        return service.delete(seatId);
    }

    @GetMapping("/getAll")
    public List<Seat> getAll() {
        return service.getAll();
    }
}
