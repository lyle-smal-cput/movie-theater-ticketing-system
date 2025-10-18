package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.service.SeatService;

/* CartItem.java
     CartItem POJO class
     Author: C Smith (221242597)
     Date: 11 May 2025 */
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;

    private String movieTitle;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double price;

    @Lob
    private byte[] image;

    protected CartItem() {}

    private CartItem(Builder builder) {
        this.cartItemId = Long.valueOf(builder.cartItemId);
        this.quantity = builder.quantity;
        this.cart = builder.cart;
        this.schedule = builder.schedule;
        this.movieTitle = builder.movieTitle;
        this.image = builder.image;
        this.customer = builder.customer;
        this.price = builder.price;
    }

    public Long getCartItemId() {
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

    public String getMovieTitle(){
        return movieTitle;
    }
    public Customer getCustomer() {
        return customer;
    }
    public byte[] getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", quantity=" + quantity +
                ", cart=" + cart +
                ", schedule=" + schedule +
                ", movieTitle='" + movieTitle + '\'' +
                ", customer=" + customer +
                ", price=" + price +
                ", image=" + image +
                '}';
    }

    public static class Builder {
        private String cartItemId;
        private int quantity;
        private Cart cart;
        private Schedule schedule;
        private String movieTitle;
        private Customer customer;
        private byte[] image;
        private double price;

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
        public Builder setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }
        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }
        public Builder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }


        public Builder copy(CartItem cartItem) {
            this.cartItemId = String.valueOf(cartItem.cartItemId);
            this.quantity = cartItem.quantity;
            this.cart = cartItem.cart;
            this.schedule = cartItem.schedule;
            this.movieTitle = cartItem.movieTitle;
            this.image = cartItem.image;
            this.customer = cartItem.customer;
            this.price = cartItem.price;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
