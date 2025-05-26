package za.ac.cput.service;

/*
 ICustomerService.java
 Customer Service Interface
 Author: LJ Smal (223236012)
     Date: 25 May 2025 */

import za.ac.cput.domain.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer, String> {
    List<Customer> getAll();
}
