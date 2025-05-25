package za.ac.cput.controller;
/* Flat Controller Test.java
     Flat Controller Test class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Flat;
import za.ac.cput.factory.FlatFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlatControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/flat";
    private Flat flat = FlatFactory.createFlat("12", "Main Road", "Gardens",
            "Cape Town", "South Africa", (short) 8001, "The Palms", (short) 302);

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Flat> response = restTemplate.postForEntity(url, flat, Flat.class);
        assertNotNull(response.getBody());
        assertEquals(flat.getAddressId(), response.getBody().getAddressId());
        System.out.println("Created: " + response.getBody());
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + flat.getAddressId();
        ResponseEntity<Flat> response = restTemplate.getForEntity(url, Flat.class);
        assertEquals(flat.getAddressId(), response.getBody().getAddressId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Flat updated = new Flat.Builder().copy(flat).setStreetName("Long Street").build();
        ResponseEntity<Flat> response = restTemplate.postForEntity(url, updated, Flat.class);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + flat.getAddressId();
        restTemplate.delete(url);
        System.out.println("Deleted: " + flat.getAddressId());
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Flat[]> response = restTemplate.getForEntity(url, Flat[].class);
        assertTrue(response.getBody().length > 0);
        System.out.println("All flats: " + response.getBody().length);
    }
}