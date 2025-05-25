package za.ac.cput.service;
/* ICartService.java
     ICart Service class
     Author: C Smith (221242597)
     Date: 25 May 2025 */

import za.ac.cput.domain.Cart;

import java.util.List;

public interface ICartService extends IService<Cart, String> {
    List<Cart>getAll();
}
