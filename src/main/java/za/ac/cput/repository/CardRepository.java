package za.ac.cput.repository;
/* Card Repository.java
        Card Repository Class
        Author: RI Onwutali (222369345)
        Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Card;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findByCardHolderName(String cardHolderName);
    List<Card> findByCardNumber(String cardNumber);

}
