package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.House;
import za.ac.cput.factory.HouseFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HouseServiceTest {
    @Autowired
    private HouseService service;

    private House house = HouseFactory.createHouse("45", "Oak Avenue", "Rondebosch",
            "Cape Town", "South Africa", (short) 7700);

    @Test
    @Order(1)
    void create() {
        House created = service.create(house);
        assertNotNull(created);
        assertEquals(house.getAddressId(), created.getAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        House read = service.read(house.getAddressId());
        assertNotNull(read);
        assertEquals(house.getAddressId(), read.getAddressId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        House updated = new House.Builder().copy(house).setStreetName("Pine Road").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = service.delete(house.getAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(5)
    void getAll() {
        service.create(house);
        List<House> houses = service.getAll();
        assertNotNull(houses);
        assertTrue(houses.size() > 0);
        System.out.println("All houses: " + houses.size());
    }
}