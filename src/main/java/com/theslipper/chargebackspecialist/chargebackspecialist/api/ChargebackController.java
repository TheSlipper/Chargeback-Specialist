package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackService;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/chargeback")
@RestController
public class ChargebackController {

    private final ChargebackService chargebackService;

    @Autowired
    public ChargebackController(ChargebackService chargebackService) {
        this.chargebackService = chargebackService;
    }

    @PutMapping
    public void addChargeback(@RequestBody Chargeback chargeback) {
        chargebackService.addChargeback(chargeback);
    }
}
