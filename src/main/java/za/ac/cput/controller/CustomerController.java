package za.ac.cput.controller;
/*
CustomerController.java
 Customer Controller class
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service, CustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable Long customerId) {
        return service.read(customerId);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public boolean delete(@PathVariable Long customerId) {
        return service.delete(customerId);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/getByEmailAndPassword/{email}/{password}")
    public Customer getCustomerByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return service.getCustomerByEmailAndPassword(email, password);//Siya
    }
}
