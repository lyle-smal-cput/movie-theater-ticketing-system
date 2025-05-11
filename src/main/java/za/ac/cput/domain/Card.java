package za.ac.cput.domain;

/* Card.java
     Card POJO class
     Author: RI Onwutali (222369345)
     Date: 11 May 2025 */

public class Card {

    private String cardNumber;
    private String cvv;
    private String cardHolderName;

    public Card(){

    }//end of Card()

    public Card(CardBuilder builder){
        this.cardNumber = builder.cardNumber;
        this.cvv = builder.cvv;
        this.cardHolderName = builder.cardHolderName;
    }//end of Card(CardBuilder)

    public String getCardNumber() {
        return cardNumber;
    }
    public String getCvv() {
        return cvv;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                '}';
    }//end of toString

    public static class CardBuilder {
        private String cardNumber;
        private String cvv;
        private String cardHolderName;

        public CardBuilder(){

        }

        public CardBuilder(String cardNumber, String cvv, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.cardHolderName = cardHolderName;
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

        public CardBuilder copy(Card card){
            this.cardNumber = card.cardNumber;
            this.cvv = card.cvv;
            this.cardHolderName = card.cardHolderName;
            return this;
        }
        public Card build(){
            return new Card(this);
        }

    }//end of static class
}//end of class

