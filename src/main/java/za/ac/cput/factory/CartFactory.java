package za.ac.cput.factory;
/* CartFactory.java
     Cart Factory class
     Author: C Smith (221242597)
     Date: 16 May 2025 */

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class CartFactory {

  public static Cart createCart(String cartId, int quantity, Customer user) {

        if (Helper.isNullOrEmpty(cartId) || quantity <= 0 || user == null) {
            return null;
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setQuantity(quantity)
                .setUser(user)
                .build();
    }

}
