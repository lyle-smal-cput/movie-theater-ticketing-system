package za.ac.cput.service;
/*
 CustomerServiceTest.java
 Customer Service Test class
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CardFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.HouseFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
    LocalDate expiryDate = LocalDate.of(2025, 12, 31);
    Customer customer = CustomerFactory.createCustomer(
            "cust123", "customer", "password", "John", "Doe", "lylesmal@gmail.com", HouseFactory.createHouse("1234", "123 Main St", "Southfield", "Cape Town", "South Africa", (short) 7880), "+27678074872", "male", LocalDate.of(1990, 1, 1), CardFactory.createCard("1234567890123456", "12/25", "username", expiryDate));

@Autowired
    private CustomerService customerService;
    @Test
    void getAll() {
        List<Customer> customers = customerService.getAll();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
    }

    @Test
    void create() {
        Customer createdCustomer = customerService.create(customer);
        assertNotNull(createdCustomer);
        assertEquals(customer.getUserId(), createdCustomer.getUserId());
        assertEquals(customer.getEmail(), createdCustomer.getEmail());
    }

    @Test
    void read() {
        Customer createdCustomer = customerService.create(customer);
        Customer readCustomer = customerService.read(createdCustomer.getUserId());
        assertNotNull(readCustomer);
        assertEquals(createdCustomer.getUserId(), readCustomer.getUserId());
        assertEquals(createdCustomer.getEmail(), readCustomer.getEmail());
    }

    @Test
    void update() {
        Customer createdCustomer = customerService.create(customer);
        Customer updatedCustomer = new Customer.Builder().copy(createdCustomer)
                .setFirstName("NewName")
                .build();
        Customer result = customerService.update(updatedCustomer);
        assertNotNull(result);
        assertEquals(updatedCustomer.getFirstName(), result.getFirstName());
        assertEquals(createdCustomer.getUserId(), result.getUserId());
        assertEquals(createdCustomer.getEmail(), result.getEmail());
    }

    @Test
    void delete() {
        Customer createdCustomer = customerService.create(customer);
        boolean isDeleted = customerService.delete(createdCustomer.getUserId());
        assertTrue(isDeleted);

        // Verify that the customer is no longer retrievable
        assertThrows(IllegalArgumentException.class, () -> customerService.read(createdCustomer.getUserId()));
    }
}