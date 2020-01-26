package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChargebackService {
    Iterable<Chargeback> getAllChargebackEntries();
    Optional<Chargeback> getChargebackByID(UUID id);
    List<Chargeback> getChargebacksByCode(Chargeback.ChargebackCode code);
    List<Chargeback> getChargebacksByDateOfAppearance(Date date);
    List<Chargeback> getChargebacksDateOfOpening(Date date);
    List<Chargeback> getChargebacksByDateOfProcessing(Date date);
    List<Chargeback> getChargebacksByCardHolderNameSurname(CardHolder cardHolder);
    List<Chargeback> getChargebacksByVendorName(Vendor vendor);

    void addChargeback(Chargeback chargeback);
}
