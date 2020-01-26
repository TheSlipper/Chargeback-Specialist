package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChargebackService {
    Iterable<Chargeback> getAllChargebackEntries();
    Optional<Chargeback> getChargebackByID(UUID id);
    Page<Chargeback> getChargebacksFromPage(int pageNo);
    Optional<Chargeback> getChargebackEntryForQueue(SystemUser systemUser);
    boolean isPageEmpty(int page);

    void addChargeback(Chargeback chargeback);
}
