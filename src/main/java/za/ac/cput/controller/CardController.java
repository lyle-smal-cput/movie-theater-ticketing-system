package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.CardService;

import za.ac.cput.domain.Card;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Card")
public class CardController {
    private CardService service;

        @Autowired
        public CardController(CardService service) {
            this.service = service;
        }

        @PostMapping("/create")
        public Card create(@RequestBody Card card) {

            return service.create(card);
        }

        @GetMapping("/read/{cardId}")
        public Card read(@PathVariable String cardId) {

            return service.read(cardId);
        }

        @PutMapping("/update")
        public Card update(@RequestBody Card card) {

            return service.update(card);
        }

        @DeleteMapping("/delete/{cardId}")
        public void delete(@PathVariable String cardId) {

            service.delete(cardId);
        }

        @GetMapping("/getAll")
        public List<Card> getAll() {
            return service.getAll();
        }


    }
