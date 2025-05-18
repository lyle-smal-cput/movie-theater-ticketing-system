package za.ac.cput.factory;
/* AddressFactory.java
    Address Factory POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address createAddress(String streetName, String streetNumber,
                                        String suburb, String city, String country, short postalCode) {
        if (Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(streetNumber) ||
                Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(country) || postalCode <= 0) {
            return null;
        }

        String addressId = Helper.generateId();

        return new Address(addressId, streetName, streetNumber, suburb, city, country, postalCode);
    }
}
