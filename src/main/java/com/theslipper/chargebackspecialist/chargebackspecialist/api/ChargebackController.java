package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackService;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/chargeback")
@RestController
public class ChargebackController {

    private final ChargebackService chargebackService;

    @Autowired
    public ChargebackController(ChargebackService chargebackService) {
        this.chargebackService = chargebackService;
    }

    @PutMapping
    private void addChargeback(@RequestBody Chargeback chargeback) {
        chargebackService.addChargeback(chargeback);
    }

    @DeleteMapping(path = "{id}")
    private void deleteByID(@PathVariable("id") UUID uuid) {
        this.deleteByID(uuid);
    }

    @GetMapping
    private Iterable<Chargeback> getAllChargebacks() {
        return this.chargebackService.getAllChargebackEntries();
    }

    @GetMapping(path = "{id}")
    private Chargeback getChargebackByID(@PathVariable("id") UUID id) {
        return this.chargebackService.getChargebackByID(id).orElse(new Chargeback());
    }
}
