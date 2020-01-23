package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardHolderRepository extends CrudRepository<CardHolder, UUID> {
}
