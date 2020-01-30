package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;

import java.util.Optional;
import java.util.UUID;

public interface CardIssuerService {

    void addCardIssuer(CardIssuer cardIssuer);
    void editCardIssuer(CardIssuer cardIssuer);
    void rmCardIssuerByID(UUID uuid);
    Iterable<CardIssuer> getAllCardIssuers();
    Iterable<CardIssuer> getCardIssuersByName(String name);
    Optional<CardIssuer> getCardIssuerByID(UUID uuid);
    boolean hasCardIssuers();
}
