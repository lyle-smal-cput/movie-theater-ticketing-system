package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    List<Admin> findByUsername(String username);
    List<Admin> findByFirstName(String firstName);
    List<Admin> findByLastName(String lastName);
    List<Admin> findByEmail(String email);

    //Not sure yet about this one
    //List<Admin> findByAddressId(String addressId);

    List<Admin> findAdminByCellphoneNumber(String cellphoneNumber);
    List<Admin> findByGender(String gender);
    List<Admin> findByDateOfBirth(LocalDate dateOfBirth);
}
