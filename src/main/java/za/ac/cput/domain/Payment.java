package za.ac.cput.domain;

import jakarta.persistence.*;
/* Payment.java
     Payment POJO class
     Author: C Smith (221242597)
     Date: 11 May 2025 */
@Entity
public class Payment {
    @Id
    private String paymentId;
    private int amount;

    protected Payment() {
    }

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static class Builder {
        private String paymentId;
        private int amount;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.amount = payment.amount;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
