package za.ac.cput.factory;

    /* AddressFactoryTest.java
     Address Factory Test POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import static org.junit.jupiter.api.Assertions.*;

public class AddressFactoryTest {
    @Test
    public void testCreateAddressSuccess() {
        Address address = AddressFactory.createAddress("Main Road", "123", "Gardens", "Cape Town", "South Africa", (short) 8001);
        assertNotNull(address);
        System.out.println(address);
    }

    @Test
    public void testCreateAddressWithNullValues() {
        Address address = AddressFactory.createAddress(null, "123", "Gardens", "Cape Town", "South Africa", (short) 8001);
        assertNull(address);
    }

    @Test
    public void testCreateAddressWithEmptyValues() {
        Address address = AddressFactory.createAddress("", "123", "Gardens", "Cape Town", "South Africa", (short) 8001);
        assertNull(address);
    }

    @Test
    public void testCreateAddressWithInvalidPostalCode() {
        Address address = AddressFactory.createAddress("Main Road", "123", "Gardens", "Cape Town", "South Africa", (short) 0);
        assertNull(address);
    }
}