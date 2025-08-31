package za.ac.cput.factory;

import za.ac.cput.domain.House;
import za.ac.cput.util.Helper;
/* HouseFactory.java
     House Factory POJO class
     Author: S Rasmeni (222906073)
     Date: 18 May 2025 */
public class HouseFactory {
    public static House createHouse(String streetNumber, String streetName,
                                    String suburb, String city, String country,
                                    short postalCode) {
        if (Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(streetNumber) ||
                Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(country) || postalCode <= 0) {
            return null;
        }

        return new House.Builder()
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setCountry(country)
                .setPostalCode(postalCode)
                .build();
    }
}
