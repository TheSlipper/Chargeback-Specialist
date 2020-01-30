package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardIssuer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardIssuerRepository extends CrudRepository<CardIssuer, UUID> {
    Iterable<CardIssuer> findCardIssuerByCardIssuerName(String name);
}
