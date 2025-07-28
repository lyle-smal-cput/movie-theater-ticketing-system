/* TheaterRoomController.java
     Theater Room Controller class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.service.TheaterRoomService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/theaterRoom")
public class TheaterRoomController {
    private TheaterRoomService service;

    @Autowired
    public TheaterRoomController(TheaterRoomService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public TheaterRoom create(@RequestBody TheaterRoom theaterRoom) {
        return service.create(theaterRoom);
    }

    @GetMapping("/read/{theaterRoomId}")
    public TheaterRoom read(@PathVariable String theaterRoomId) {
        return service.read(theaterRoomId);
    }

    @PutMapping("/update")
    public TheaterRoom update(@RequestBody TheaterRoom theaterRoom) {
        return service.update(theaterRoom);
    }

    @DeleteMapping("/delete/{theaterRoomId}")
    public boolean delete(@PathVariable String theaterRoomId) {
        return service.delete(theaterRoomId);
    }

    @GetMapping("/getAll")
    public List<TheaterRoom> getAll() {
        return service.getAll();
    }
}
