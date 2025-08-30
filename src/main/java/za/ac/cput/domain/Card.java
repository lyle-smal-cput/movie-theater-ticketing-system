package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

/* Card.java
     Card POJO class
     Author: RI Onwutali (222369345)
     Date: 11 May 2025 */

@Entity
public class Card {

    @Id
    @Column(name = "card_number")
    private String cardNumber;  // Primary key

    private String cvv;
    private String cardHolderName;
    private LocalDate expiryDate;

    //TODO: Add expiryDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")  // foreign key column
    private Customer customer;

    protected Card() { }

    public Card(CardBuilder builder) {
        this.cardNumber = builder.cardNumber;
        this.cvv = builder.cvv;
        this.cardHolderName = builder.cardHolderName;
        this.expiryDate = builder.expiryDate;
        this.customer = builder.customer;
    }

    // Getters and setters...

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public LocalDate getExpiryDate() {return expiryDate; }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", customer=" + (customer != null ? customer.getUserId() : "null") +
                '}';
    }

    public static class CardBuilder {
        private String cardNumber;
        private String cvv;
        private String cardHolderName;
        private LocalDate expiryDate;
        private Customer customer;

        public CardBuilder() { }

        public CardBuilder(String cardNumber, String cvv, String cardHolderName, LocalDate expiryDate) {
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.cardHolderName = cardHolderName;
            this.expiryDate = expiryDate;
        }

        public CardBuilder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public CardBuilder setCvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public CardBuilder setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
            return this;
        }

        public CardBuilder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public CardBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public CardBuilder copy(Card card) {
            this.cardNumber = card.cardNumber;
            this.cvv = card.cvv;
            this.cardHolderName = card.cardHolderName;
            this.expiryDate = card.expiryDate;
            this.customer = card.customer;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}