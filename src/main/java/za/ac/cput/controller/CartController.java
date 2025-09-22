package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart) {
        return service.create(cart);
    }

    @GetMapping("/read/{id}")
    public Cart read(@PathVariable Long id) {
        return service.read(id);
    }

    @GetMapping("/readByUserId/{id}")
    public Cart readByUserId(@PathVariable Long id) {
        return service.readByUserId(id);
    }

    @PutMapping("/update")
    public Cart update(@RequestBody Cart cart) {
        return service.update(cart);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Cart> getAll() {
        return service.getAll();
    }
}
