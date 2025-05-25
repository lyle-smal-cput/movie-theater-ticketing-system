package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Flat;
import za.ac.cput.factory.FlatFactory;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlatServiceTest {
    @Autowired
    private FlatService service;

    private Flat flat = FlatFactory.createFlat("12", "Main Road", "Gardens",
            "Cape Town", "South Africa", (short) 8001, "The Palms", (short) 302);

    @Test
    @Order(1)
    void create() {
        Flat created = service.create(flat);
        assertNotNull(created);
        assertEquals(flat.getAddressId(), created.getAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Flat read = service.read(flat.getAddressId());
        assertNotNull(read);
        assertEquals(flat.getAddressId(), read.getAddressId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Flat updated = new Flat.Builder().copy(flat).setStreetName("Long Street").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = service.delete(flat.getAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(6)
    void getAll() {
        service.create(flat);
        List<Flat> flats = service.getAll();
        assertNotNull(flats);
        assertTrue(flats.size() > 0);
        System.out.println("All flats: " + flats.size());
    }
}