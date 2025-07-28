package za.ac.cput.controller;
/* Flat Controller.java
     Flat Controller class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Flat;
import za.ac.cput.service.FlatService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/flat")
public class FlatController {
    private FlatService service;

    @Autowired
    public FlatController(FlatService service){this.service = service;}

    @PostMapping("/create")
    public Flat create(@RequestBody Flat flat) {
        return service.create(flat);
    }

    @GetMapping("/read/{addressId}")
    public Flat read(@PathVariable String addressId) {
        return service.read(addressId);
    }

    @PutMapping("/update")
    public Flat update(@RequestBody Flat flat) {
        return service.update(flat);
    }

    @DeleteMapping("/delete/{addressId}")
    public boolean delete(@PathVariable String addressId) {
        return service.delete(addressId);
    }

    @GetMapping("/getAll")
    public List<Flat> getAll() {
       return service.getAll();
    }
}