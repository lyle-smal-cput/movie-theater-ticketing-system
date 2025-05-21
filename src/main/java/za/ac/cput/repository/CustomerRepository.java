package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByUsername(String username);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByEmail(String email);

    //Not sure yet about this one
    //List<Admin> findByAddressId(String addressId);

    List<Customer> findAdminByCellphoneNumber(String cellphoneNumber);
    List<Customer> findByGender(String gender);
    List<Customer> findByDateOfBirth(LocalDate dateOfBirth);
    List<Customer> findByCardNumber(String cardNumber);
}
