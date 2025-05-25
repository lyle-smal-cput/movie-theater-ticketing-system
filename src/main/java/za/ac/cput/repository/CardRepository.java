package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Card;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    List<Card> findByCardHolderName(String cardHolderName);
    List<Card> findByCardNumber(String cardNumber);

}
