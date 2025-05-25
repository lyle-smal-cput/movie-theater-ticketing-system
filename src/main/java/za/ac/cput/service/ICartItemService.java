package za.ac.cput.service;
/* ICartItemService.java
     ICart Item Service class
     Author: C Smith (221242597)
     Date: 25 May 2025 */
import za.ac.cput.domain.CartItem;

import java.util.List;

public interface ICartItemService extends IService<CartItem,String>{
    List<CartItem> getAll();
}
