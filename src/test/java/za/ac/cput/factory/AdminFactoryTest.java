package za.ac.cput.factory;
/* AdminFactoryTest.java
     Admin Factory Test class
     Author: LJ Smal (223236012)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.House;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class AdminFactoryTest {
    House address = HouseFactory.createHouse("123456789", "Main Street", "28", "Cape Town", "South Africa", (short) 8000);
    Admin admin;

    @Test
    void createAdmin() {
        admin = AdminFactory.createAdmin("223236012", "lylesmal", "12345678", "Lyle", "Smal", "lylesmal@gmail.com", address, "+2782123456", "male", LocalDate.of(2004, 1, 26));
        assertNotNull(admin);
        System.out.println(admin.toString());
    }
}