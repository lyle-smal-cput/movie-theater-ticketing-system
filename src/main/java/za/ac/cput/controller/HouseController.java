package za.ac.cput.controller;
/* House Controller.java
     House Controller class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.House;
import za.ac.cput.service.HouseService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/house")
public class HouseController {

    private HouseService service;

    @Autowired
    public HouseController(HouseService service){this.service = service;}

    @PostMapping("/create")
    public House create(@RequestBody House house) {
        return service.create(house);
    }

    @GetMapping("/read/{addressId}")
    public House read(@PathVariable Long addressId) {
        return service.read(addressId);
    }

    @PutMapping("/update")
    public House update(@RequestBody House house) {
        return service.update(house);
    }

    @DeleteMapping("/delete/{addressId}")
    public boolean delete(@PathVariable Long addressId) {
        return service.delete(addressId);
    }

    @GetMapping("/getAll")
    public List<House> getAll() {
       return service.getAll();
    }
}
