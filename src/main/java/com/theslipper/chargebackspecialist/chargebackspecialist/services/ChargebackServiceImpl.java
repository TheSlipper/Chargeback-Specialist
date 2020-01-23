package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.ChargebackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChargebackServiceImpl implements ChargebackService {

    @Autowired
    private ChargebackRepository chargebackRepo;

    @Override
    public Iterable<Chargeback> getAllChargebackEntries() {
        return chargebackRepo.findAll();
    }

    @Override
    public List<Chargeback> getChargebacksByCode(Chargeback.ChargebackCode code) {
        return null;
    }

    @Override
    public List<Chargeback> getChargebacksByDateOfAppearance(Date date) {
        return null;
    }

    @Override
    public List<Chargeback> getChargebacksDateOfOpening(Date date) {
        return null;
    }

    @Override
    public List<Chargeback> getChargebacksByDateOfProcessing(Date date) {
        return null;
    }

    @Override
    public List<Chargeback> getChargebacksByCardHolderNameSurname(CardHolder cardHolder) {
        return null;
    }

    @Override
    public List<Chargeback> getChargebacksByVendorName(Vendor vendor) {
        return null;
    }

    @Override
    public void addChargeback(Chargeback chargeback) {
        chargebackRepo.save(chargeback);
    }
}
