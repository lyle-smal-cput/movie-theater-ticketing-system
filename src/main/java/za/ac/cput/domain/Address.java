package za.ac.cput.domain;
/* Address.java
     Address POJO class
     Author: S Rasmeni (222906073)
     Date: 11 May 2025 */

public class Address {
    protected String addressId;
    protected String streetName;
    protected String streetNumber;
    protected String suburb;
    protected String city;
    protected String country;
    protected short postalCode;
    protected Address() {}

    public Address(String addressId, String streetName, String streetNumber,
                   String suburb, String city, String country, short postalCode) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(short postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}

