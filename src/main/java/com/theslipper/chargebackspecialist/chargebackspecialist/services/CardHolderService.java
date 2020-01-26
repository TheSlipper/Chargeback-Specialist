package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;

import java.util.Optional;
import java.util.UUID;

public interface CardHolderService {

    void addCardHolder(CardHolder CardHolder);
    void editCardHolder(CardHolder CardHolder);
    void rmCardHolderByID(UUID uuid);
    Iterable<CardHolder> getAllCardHolders();
    Optional<CardHolder> getCardHolderByID(UUID uuid);

}
