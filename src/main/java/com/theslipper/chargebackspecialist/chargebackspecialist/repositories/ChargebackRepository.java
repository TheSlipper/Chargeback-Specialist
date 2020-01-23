package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChargebackRepository extends CrudRepository<Chargeback, UUID> {
}
