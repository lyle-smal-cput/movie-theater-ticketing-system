package za.ac.cput.service;

import za.ac.cput.domain.Card;

import java.util.List;

public interface ICardService extends IService<Card, String>{
    List<Card> getAll();
}
