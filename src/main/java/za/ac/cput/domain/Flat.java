package za.ac.cput.domain;
/* Flat.java
     Flat POJO class
     Author: S Rasmeni (222906073)
     Date: 11 May 2025 */
public class Flat extends Address {
    private short unitNumber;
    private String complexName;

    public Flat() {
    }

    private Flat(Builder builder) {
        this.addressId = builder.addressId;
        this.streetName = builder.streetName;
        this.unitNumber = builder.unitNumber;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.country = builder.country;
        this.postalCode = builder.postalCode;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public short getUnitNumber() {
        return unitNumber;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "complexName='" + complexName + '\'' +
                ", unitNumber=" + unitNumber +
                ", addressId='" + addressId + '\'' +
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
        private String complexName;
        private short unitNumber;

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
            this.country = country;
            return this;
        }

        public Builder setPostalCode(short postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setUnitNumber(short unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder copy(Flat flat) {
            this.addressId = flat.addressId;
            this.streetNumber = flat.streetNumber;
            this.streetName = flat.streetName;
            this.suburb = flat.suburb;
            this.city = flat.city;
            this.country = flat.country;
            this.postalCode = flat.postalCode;
            this.complexName = flat.complexName;
            this.unitNumber = flat.unitNumber;
            return this;
        }

        public Flat build() {
            return new Flat(this);
        }
    }
}
