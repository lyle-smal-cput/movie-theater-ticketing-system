package za.ac.cput.factory;
/* FlatFactory.java
     Flat Factory POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import za.ac.cput.domain.Flat;
import za.ac.cput.util.Helper;

public class FlatFactory {
    public static Flat createFlat(String streetNumber, String streetName, String suburb,
                                  String city, String country, short postalCode,
                                  String complexName, short unitNumber) {
        if (Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(streetNumber) ||
                Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(country) || postalCode <= 0 ||
                Helper.isNullOrEmpty(complexName) || unitNumber <= 0) {
            return null;
        }

        String addressId = Helper.generateId();

        return new Flat.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setCountry(country)
                .setPostalCode(postalCode)
                .setComplexName(complexName)
                .setUnitNumber(unitNumber)
                .build();
    }
}

