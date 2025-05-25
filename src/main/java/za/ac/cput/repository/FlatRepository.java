package za.ac.cput.repository;
/* FlatRepository.java
    Flat Repository interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Flat;

import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, String> {
    Flat findByAddressId(String AddressId);
    List<Flat> findByStreetName(String streetName);
    List<Flat> findByStreetNumber(String streetNumber);
    List<Flat> findBySuburb(String suburb);
    List<Flat> findByCity(String city);
    List<Flat> findByCountry(String country);
    List<Flat> findByPostalCode(short postalCode);
    List<Flat>findByComplexName(String complexName);
    List<Flat> findByUnitNumber(short unitNumber);
}

