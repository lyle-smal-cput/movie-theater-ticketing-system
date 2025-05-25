package za.ac.cput.repository;
/* HouseRepository.java
     House Repository interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {
    House findByAddressId(String AddressId);
    List<House> findByStreetName(String streetName);
    List<House> findByStreetNumber(String streetNumber);
    List<House> findBySuburb(String suburb);
    List<House> findByCity(String city);
    List<House> findByCountry(String country);
    List<House> findByPostalCode(short postalCode);
}