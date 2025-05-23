package za.ac.cput.domain;

import jakarta.persistence.*;

/* CartItem.java
     CartItem POJO class
     Author: C Smith (221242597)
     Date: 11 May 2025 */
@Entity
public class CartItem {
    @Id
    private String cartItemId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;

    protected CartItem() {}

    private CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.quantity = builder.quantity;
        this.cart = builder.cart;
        this.schedule = builder.schedule;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", quantity=" + quantity +
                ", cart=" + cart +
                ", schedule=" + schedule +
                '}';
    }

    public static class Builder {
        private String cartItemId;
        private int quantity;
        private Cart cart;
        private Schedule schedule;

        public Builder setCartItemId(String cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setSchedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemId = cartItem.cartItemId;
            this.quantity = cartItem.quantity;
            this.cart = cartItem.cart;
            this.schedule = cartItem.schedule;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
