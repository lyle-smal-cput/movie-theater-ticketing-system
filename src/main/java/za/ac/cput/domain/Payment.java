package za.ac.cput.domain;

/* Payment.java
     Payment POJO class
     Author: Christian Smith (221242597)
     Date: 11 May 2025 */

public class Payment {
    private String paymentId;
    private int amount;

    private Payment() {
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
