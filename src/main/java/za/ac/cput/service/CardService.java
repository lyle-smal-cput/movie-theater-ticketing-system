package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Card;
import za.ac.cput.repository.CardRepository;

import java.util.List;

@Service
public class CardService implements ICardService {

    private CardRepository repository;

    @Autowired
    CardService(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Card create (Card card){
        return repository.save(card);
    }

    @Override
    public Card read (String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Card update (Card card){
        return this.repository.save(card);
    }

    @Override
    public boolean delete(String id){
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Card> getAll(){
        return this.repository.findAll();
    }
}
