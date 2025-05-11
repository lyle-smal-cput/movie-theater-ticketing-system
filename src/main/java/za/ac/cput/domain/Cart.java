package za.ac.cput.domain;

/* Cart.java
     Cart POJO class
     Author: Christian Smith (221242597)
     Date: 11 May 2025 */

public class Cart {
    private String cartId;
    private int quantity;
    private User user;

    private Cart() {
    }

    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.quantity = builder.quantity;
        this.user = builder.user;
    }

    public String getCartId() {
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
            this.cartId = cart.cartId;
            this.quantity = cart.quantity;
            this.user = cart.user;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
