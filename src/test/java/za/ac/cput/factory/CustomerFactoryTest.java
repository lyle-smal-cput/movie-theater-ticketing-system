package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Card;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.House;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    House address = new House.Builder().setAddressId("123456789").setStreetName("Main Street").setStreetNumber("28").setCity("Cape Town").setPostalCode((short)8000).setCountry("South Africa").setSuburb("Southfield").build();
    Card card = new Card.CardBuilder().setCardNumber("1234567890123456").setCvv("123").setCardHolderName("Lyle Smal").build();
    Customer customer;

    @Test
    void createCustomer() {
        customer = CustomerFactory.createCustomer("223236012", "lylesmal", "12345678", "Lyle", "Smal", "lylesmal@gmail.com", address, "+2782123456", "male", LocalDate.of(2004, 1, 26), card);
        assertNotNull(customer);
        System.out.println(customer.toString());
    }
}