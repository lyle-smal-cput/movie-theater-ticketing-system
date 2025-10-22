package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.config.JwtUtil;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;
    private final JwtUtil jwtUtil;

    @Autowired
    public CustomerController(CustomerService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        // 1️⃣ Create and save the customer
        Customer saved = service.create(customer);

        // 2️⃣ Generate a token for this new customer
        String token = jwtUtil.generateToken(saved.getUsername(), "CUSTOMER");

        // 3️⃣ Return both customer info and token
        return ResponseEntity.ok(Map.of(
                "userId", saved.getUserId(),
                "username", saved.getUsername(),
                "email", saved.getEmail(),
                "role", "CUSTOMER",
                "token", token
        ));
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable Long customerId) {
        return service.read(customerId);
    }

    @GetMapping("/readByUsername/{username}")
    public Customer readByUsername(@PathVariable String username) {
        return service.readByUsername(username);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{customerId}")
    public boolean delete(@PathVariable Long customerId) {
        return service.delete(customerId);
    }

    @GetMapping("/getAll")
    public java.util.List<Customer> getAll() {
        return service.getAll();
    }
}
