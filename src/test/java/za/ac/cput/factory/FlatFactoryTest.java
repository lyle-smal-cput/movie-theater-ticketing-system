package za.ac.cput.factory;
/* FlatFactoryTest.java
     Flat Factory Test POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Flat;

import static org.junit.jupiter.api.Assertions.*;

class FlatFactoryTest {
    @Test
    void testCreateFlatSuccess() {
        Flat flat = FlatFactory.createFlat("45", "Ocean View Drive", "Sea Point",
                "Cape Town", "South Africa", (short) 8005,
                "The Waves Complex", (short) 302);
        assertNotNull(flat);
        System.out.println(flat);
    }

    @Test
    void testCreateFlatFieldsCorrectlySet() {
        Flat flat = FlatFactory.createFlat("45", "Ocean View Drive", "Sea Point",
                "Cape Town", "South Africa", (short) 8005,
                "The Waves Complex", (short) 302);

        assertNotNull(flat);
        assertEquals("45", flat.getStreetNumber());
        assertEquals("Ocean View Drive", flat.getStreetName());
        assertEquals(302, flat.getUnitNumber());
    }

    @Test
    void testCreateFlatWithInvalidUnitNumber() {
        Flat flat = FlatFactory.createFlat("45", "Ocean View Drive", "Sea Point",
                "Cape Town", "South Africa", (short) 8005,
                "The Waves Complex", (short) 0);
        assertNull(flat);
    }

    @Test
    void testCreateFlatWithMissingComplexName() {
        Flat flat = FlatFactory.createFlat("45", "Ocean View Drive", "Sea Point",
                "Cape Town", "South Africa", (short) 8005,
                null, (short) 302);
        assertNull(flat);
    }

    @Test
    void testCreateFlatWithEmptyStreetName() {
        Flat flat = FlatFactory.createFlat("45", "", "Sea Point",
                "Cape Town", "South Africa", (short) 8005,
                "The Waves Complex", (short) 302);
        assertNull(flat);
    }
}