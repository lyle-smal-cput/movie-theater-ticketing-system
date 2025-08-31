package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/* CardFactoryTest.java
     Card Factory Test class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
class CardFactoryTest {

    @Test
    void createCard() {
        LocalDate expiryDate = LocalDate.of(2025, 12, 31);
        Card card = CardFactory.createCard("5236953214563214", "966", "Minghao Xu", expiryDate);
        assertNotNull(card);
        System.out.println(card);
    }

}