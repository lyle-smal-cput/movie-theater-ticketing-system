package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    private final CartItemService service;

    @Autowired
    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem) {
        return service.create(cartItem);
    }

    @GetMapping("/read/{id}")
    public CartItem read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem) {
        return service.update(cartItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<CartItem> getAll() {
        return service.getAll();
    }
}
