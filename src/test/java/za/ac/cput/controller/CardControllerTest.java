package za.ac.cput.controller;

/* Card Controller Test.java
        Card Controller Test Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025 */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Card;
import za.ac.cput.factory.CardFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    static LocalDate expiryDate = LocalDate.of(2025, 12, 31);
    private static Card card = new CardFactory().createCard("7456 6235 6984 5336", "856", "Ruth Ifeoma", expiryDate);

    private static final String BASE_URL = "http://localhost:8080/movie-theater-ticketing-system/card";

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Card> response = restTemplate.postForEntity(url, card, Card.class);
        assertNotNull(response);
        Card responseCard = response.getBody();
        assertEquals(card.getCardNumber(), responseCard.getCardNumber());
        System.out.println("Created" + responseCard);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + card.getCardNumber();
        ResponseEntity<Card> response = this.restTemplate.getForEntity(url, Card.class);
        assertEquals(card.getCardNumber(), response.getBody().getCardNumber());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Card updateCard = new Card.CardBuilder().copy(card).setCardNumber("5426 6354 3645 3684")
                .build();
        this.restTemplate.put(url, updateCard);
        ResponseEntity<Card> response = restTemplate.getForEntity(BASE_URL + "/read/" + updateCard.getCardNumber(), Card.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
       assertNotNull(response.getBody());
       System.out.println("Update: " + response.getBody());

    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + card.getCardNumber();
        restTemplate.delete(url);
        ResponseEntity<Card> response = restTemplate.getForEntity(BASE_URL + "/read/" + card.getCardNumber(), Card.class);
        assertNull(response.getBody());
        System.out.println("Deleted:" + "true");

    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Card[]> response = this.restTemplate.getForEntity(url, Card[].class);
        assertTrue(response.getBody().length > 0);
        System.out.println("Get All: ");
        for (Card card : response.getBody()) {
            System.out.println(card);
        }
    }
}