package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.*;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.ChargebackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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
    public Optional<Chargeback> getChargebackEntryForQueue(SystemUser systemUser) {
        if (systemUser.getSystemUserRole().hasPermission(SystemUserRole.SystemPermission.PROCESS_VISA_CHARGEBACK)
            || systemUser.getSystemUserRole().hasPermission(SystemUserRole.SystemPermission.PROCESS_MASTERCARD_CHARGEBACK)) {
            Chargeback targetChargeback = null;
            Iterator<Chargeback> chargebacks = this.chargebackRepo.findAll().iterator();

            while (chargebacks.hasNext()) {
                Chargeback chargeback = chargebacks.next();
                if(systemUser.getSystemUserRole().hasPermission(SystemUserRole.SystemPermission.PROCESS_VISA_CHARGEBACK) &&
                        (chargeback.getConcernedCardHolder().getCardholdersCardNumber().startsWith("4") &&
                                chargeback.getChargebackOpenedDate() == null) ||
                        systemUser.getSystemUserRole().
                                hasPermission(SystemUserRole.SystemPermission.PROCESS_MASTERCARD_CHARGEBACK)) {
                    targetChargeback = chargeback;
                    break;
                }
            }
            return Optional.of(targetChargeback);
        }
        return Optional.empty();
    }

    @Override
    public boolean isPageEmpty(int pageNo) {
        Page<Chargeback> chargebacks = chargebackRepo.findAll(PageRequest.of(pageNo, 5));
        return chargebacks.getTotalPages() <= pageNo;
    }

    @Override
    public void addChargeback(Chargeback chargeback) {
        chargebackRepo.save(chargeback);
    }
}
