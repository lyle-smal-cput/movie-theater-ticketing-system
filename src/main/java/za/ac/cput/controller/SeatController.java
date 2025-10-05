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

@CrossOrigin(origins = "http://localhost:5173")
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
    public Seat read(@PathVariable Long seatId) {
        return service.read(seatId);
    }

    @PutMapping("/update")
    public Seat update(@RequestBody Seat seat) {
        return service.update(seat);
    }

    @DeleteMapping("/delete/{seatId}")
    public boolean delete(@PathVariable Long seatId) {
        return service.delete(seatId);
    }

    @GetMapping("/getAll")
    public List<Seat> getAll() {
        return service.getAll();
    }

    @PutMapping("/updateSeats/{Id}/{isAvailable}")
    public int updateSeatAvailability(@PathVariable Long Id, @PathVariable boolean isAvailable) {
        return service.updateSeatAvailability(Id, isAvailable);
    }

    @GetMapping("/getAllByAvailability/{id}/{isAvailable}")
    public List<Seat> getAllSeatsByTheaterRoomIdAndAvailability(@PathVariable Long id, @PathVariable boolean isAvailable){
        return service.findSeatsByTheaterRoom_TheaterRoomIdAndAvailable(id, isAvailable);
    }
}
