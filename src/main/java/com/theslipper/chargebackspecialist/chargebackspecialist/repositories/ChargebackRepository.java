package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ChargebackRepository extends PagingAndSortingRepository<Chargeback, UUID> {
    Page<Chargeback> findAllByChargebackProcessID(UUID uuid, Pageable pageable);
    Page<Chargeback> findAllByChargebackCode(Chargeback.ChargebackCode code, Pageable pageable);
    Page<Chargeback> findAllByChargebackOpenedDate(java.util.Date chargebackOpenedDate, Pageable pageable);
    Page<Chargeback> findAllByChargebackProcessedDate(java.util.Date chargebackProcessedDate, Pageable pageable);
}
