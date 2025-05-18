package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

/* CardFactoryTest.java
     Card Factory Test class
     Author: RI Onwutali (222369345)
     Date: 18 May 2025 */
class CardFactoryTest {

    @Test
    void createCard() {
        Card card = new CardFactory().createCard("5236953214563214", "966", "Minghao Xu");
        assertNotNull(card);
        System.out.println(card);
    }

}