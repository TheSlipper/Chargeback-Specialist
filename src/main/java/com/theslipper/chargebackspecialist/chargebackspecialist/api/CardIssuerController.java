package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.CardIssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/cardissuer")
@RestController
public class CardIssuerController {

    private final CardIssuerService cardIssuerService;

    @Autowired
    public CardIssuerController(CardIssuerService cardIssuerService) {
        this.cardIssuerService = cardIssuerService;
    }

    @PutMapping
    private void addCardIssuer(@RequestBody CardIssuer cardIssuer) {
        this.cardIssuerService.addCardIssuer(cardIssuer);
    }

    @DeleteMapping(path = "{id}")
    private void deleteCardIssuerByID(@PathVariable("id") UUID uuid) {
        this.cardIssuerService.rmCardIssuerByID(uuid);
    }

    @GetMapping(path = "{id}")
    private CardIssuer getCardIssuerByID(@PathVariable("id") UUID uuid) {
        return this.cardIssuerService.getCardIssuerByID(uuid).orElse(new CardIssuer());
    }

    @GetMapping
    private Iterable<CardIssuer> getCardIssuers() {
        return this.cardIssuerService.getAllCardIssuers();
    }

}
