package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.CardHolder;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.ChargebackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChargebackServiceImpl implements ChargebackService {

    @Autowired
    private ChargebackRepository chargebackRepo;

    @Override
    public Iterable<Chargeback> getAllChargebackEntries() {
        return chargebackRepo.findAll();
    }

    @Override
    public Optional<Chargeback> getChargebackByID(UUID id) {
        return this.chargebackRepo.findById(id);
    }

    @Override
    public Page<Chargeback> getChargebacksFromPage(int pageNo) {
        return chargebackRepo.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public boolean isPageEmpty(int pageNo) {
        Page<Chargeback> chargebacks = chargebackRepo.findAll(PageRequest.of(pageNo, 5));
        return chargebacks.getTotalPages() <= pageNo;
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
