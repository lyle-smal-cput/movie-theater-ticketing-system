package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;


/* Cart.java
     Cart POJO class
     Author: C Smith (221242597)
     Date: 11 May 2025 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    protected Cart() {
    }

    private Cart(Builder builder) {
        this.cartId = Long.valueOf(builder.cartId);
        this.quantity = builder.quantity;
        this.user = builder.user;
    }

    public Long getCartId() {
        return cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private String cartId;
        private int quantity;
        private User user;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = String.valueOf(cart.cartId);
            this.quantity = cart.quantity;
            this.user = cart.user;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
