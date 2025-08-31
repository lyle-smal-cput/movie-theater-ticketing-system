package za.ac.cput.repository;
/* CartItemRepository.java
     Cart Item Repository class
     Author: C Smith (221242597)
     Date: 23 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartItem;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartItemId(Long cartItemId);
    List<CartItem> findByCartCartId(Long cartId);
    List<CartItem> findByScheduleScheduleId(Long scheduleId);
    List<CartItem> findByQuantity(int quantity);
}
