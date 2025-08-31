package za.ac.cput.repository;

/* AdminRepository.java
     Admin Repository interface
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
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUserId(Long userId);
    List<Admin> findByUsername(String username);
    List<Admin> findByFirstName(String firstName);
    List<Admin> findByLastName(String lastName);
    List<Admin> findByEmail(String email);
    List<Admin> findByAddressAddressId(Long addressId);
    List<Admin> findAdminByCellphoneNumber(String cellphoneNumber);
    List<Admin> findByGender(String gender);
    List<Admin> findByDateOfBirth(LocalDate dateOfBirth);
}
