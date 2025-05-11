package za.ac.cput.domain;
/* House.java
     House POJO class
     Author: S Rasmeni (222906073)
     Date: 11 May 2025 */

public class House extends Address {

    public House() {
    }

    private House(Builder builder) {
        this.addressId = builder.addressId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.country = builder.country;
        this.postalCode = builder.postalCode;
    }

    @Override
    public String toString() {
        return "House{" +
                "addressId='" + addressId + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder {
        private String addressId;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String city;
        private String country;
        private short postalCode;

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setCountry(String country) {
            this.country= country;
            return this;
        }
        public Builder setPostalCode(short postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(House house) {
            this.addressId = house.addressId;
            this.streetNumber = house.streetNumber;
            this.streetName = house.streetName;
            this.suburb = house.suburb;
            this.city = house.city;
            this.country = house.country;
            this.postalCode = house.postalCode;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

