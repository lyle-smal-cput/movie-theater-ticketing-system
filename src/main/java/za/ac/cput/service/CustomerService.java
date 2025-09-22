package za.ac.cput.service;

/*
 CustomerService.java
 Customer Service class
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(Long string) {
        return customerRepository.findById(string)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + string));
    }

    public Customer readByUsername(String string) {
        return customerRepository.findByUsername(string);
    }


    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean delete(Long string) {
        customerRepository.deleteById(string);
        return true;
    }
}
