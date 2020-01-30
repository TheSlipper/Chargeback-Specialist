package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.CardIssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardIssuerServiceImpl implements CardIssuerService {

    @Autowired
    private CardIssuerRepository cardIssuerRepository;

    @Override
    public void addCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuerRepository.save(cardIssuer);
    }

    @Override
    public void editCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuerRepository.save(cardIssuer);
    }

    @Override
    public void rmCardIssuerByID(UUID uuid) {
        this.cardIssuerRepository.deleteById(uuid);
    }

    @Override
    public Iterable<CardIssuer> getAllCardIssuers() {
        return this.cardIssuerRepository.findAll();
    }

    @Override
    public Iterable<CardIssuer> getCardIssuersByName(String name) {
        return this.cardIssuerRepository.findCardIssuerByCardIssuerName(name);
    }

    @Override
    public Optional<CardIssuer> getCardIssuerByID(UUID uuid) {
        return this.cardIssuerRepository.findById(uuid);
    }

    @Override
    public boolean hasCardIssuers() {
        return this.cardIssuerRepository.findAll().iterator().hasNext();
    }
}
