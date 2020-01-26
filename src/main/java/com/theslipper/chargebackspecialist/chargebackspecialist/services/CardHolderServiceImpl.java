package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.CardHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardHolderServiceImpl implements CardHolderService {

    @Autowired
    private CardHolderRepository cardHolderRepository;

    @Override
    public void addCardHolder(CardHolder CardHolder) {
        this.cardHolderRepository.save(CardHolder);
    }

    @Override
    public void editCardHolder(CardHolder CardHolder) {
        this.cardHolderRepository.save(CardHolder);
    }

    @Override
    public void rmCardHolderByID(UUID uuid) {
        this.cardHolderRepository.deleteById(uuid);
    }

    @Override
    public Iterable<CardHolder> getAllCardHolders() {
        return this.cardHolderRepository.findAll();
    }

    @Override
    public Optional<CardHolder> getCardHolderByID(UUID uuid) {
        return this.cardHolderRepository.findById(uuid);
    }
}
