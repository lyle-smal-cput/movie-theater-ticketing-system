package za.ac.cput.factory;
/* HouseFactoryTest.java
     House Factory Test POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.House;

import static org.junit.jupiter.api.Assertions.*;

class HouseFactoryTest {
    @Test
    void createHouse() {
        House house = HouseFactory.createHouse("22", "Kloof Street",
                "Gardens", "Cape Town",
                "South Africa", (short) 8001);

        assertNotNull(house);
        assertEquals("22", house.getStreetNumber());
        assertEquals("Kloof Street", house.getStreetName());
        assertEquals("Gardens", house.getSuburb());
        assertEquals((short) 8001, house.getPostalCode());
        assertNotNull(house.getAddressId());
        System.out.println(house);
    }

    @Test
    void createHouseWithInvalidPostalCode() {
        House house = HouseFactory.createHouse("22", "Kloof Street",
                "Gardens", "Cape Town",
                "South Africa", (short) 0);
        assertNull(house, "House with postal code 0 should be invalid");
    }

    @Test
    void createHouseWithNegativePostalCode() {
        House house = HouseFactory.createHouse("22", "Kloof Street",
                "Gardens", "Cape Town",
                "South Africa", (short) -1000);
        assertNull(house, "House with negative postal code should be invalid");
    }

    @Test
    void createHouseWithMissingStreetName() {
        House house = HouseFactory.createHouse("22", null,
                "Gardens", "Cape Town",
                "South Africa", (short) 8001);
        assertNull(house, "House with null street name should be invalid");
    }

    @Test
    void createHouseWithEmptyStreetNumber() {
        House house = HouseFactory.createHouse("", "Kloof Street",
                "Gardens", "Cape Town",
                "South Africa", (short) 8001);
        assertNull(house, "House with empty street number should be invalid");
    }

}