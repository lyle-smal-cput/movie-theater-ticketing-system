package za.ac.cput.service;
/* ICard Service.java
     Card Service class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import za.ac.cput.domain.Card;

import java.util.List;

public interface ICardService extends IService<Card, String>{
    List<Card> getAll();
}
