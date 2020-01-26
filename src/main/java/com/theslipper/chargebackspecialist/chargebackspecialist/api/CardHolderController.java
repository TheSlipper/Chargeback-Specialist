package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/cardholder")
@RestController
public class CardHolderController {

    private final CardHolderService cardHolderService;

    @Autowired
    public CardHolderController(CardHolderService cardHolderService) {
        this.cardHolderService = cardHolderService;
    }

    @PutMapping
    private void addCardHolder(@RequestBody CardHolder cardHolder) {
        this.cardHolderService.addCardHolder(cardHolder);
    }

    @DeleteMapping(path = "{id}")
    private void deletebyID(@PathVariable("id") UUID id) {
        this.cardHolderService.rmCardHolderByID(id);
    }

    @GetMapping
    private Iterable<CardHolder> getCardHolders() {
        return this.cardHolderService.getAllCardHolders();
    }

    @GetMapping(path = "{id}")
    private CardHolder getCardHolderByID(@PathVariable("id") UUID id) {
        return this.cardHolderService.getCardHolderByID(id).orElse(new CardHolder());
    }

}
