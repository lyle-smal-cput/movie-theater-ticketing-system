package za.ac.cput.repository;

/* CustomerRepository.java
     Customer Repository interface
     Author: LJ Smal (223236012)
     Date: 21 May 2025 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserId(Long userId);
    List<Customer> findByUsername(String username);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);//Siya
    List<Admin> findByAddressAddressId(Long addressId);
    List<Customer> findAdminByCellphoneNumber(String cellphoneNumber);
    List<Customer> findByGender(String gender);
    List<Customer> findByDateOfBirth(LocalDate dateOfBirth);
    List<Customer> findByCardsCardNumber(String cardNumber);
}
