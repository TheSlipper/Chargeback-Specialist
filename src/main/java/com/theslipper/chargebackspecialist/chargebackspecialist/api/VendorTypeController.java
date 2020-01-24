package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.VendorType;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/vendortype")
@RestController
public class VendorTypeController {

    private final VendorService vendorService;

    @Autowired
    public VendorTypeController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PutMapping
    private void addVendorType(@RequestBody VendorType vendorType) {
        this.vendorService.addVendorType(vendorType);
    }

    @DeleteMapping(path = "{id}")
    private void rmVendorType(@PathVariable("id") UUID id) {
        this.vendorService.rmVendorTypeByID(id);
    }

    @GetMapping
    private Iterable<VendorType> getVendorTypes() {
        return this.vendorService.getAllVendorTypes();
    }

    @GetMapping(path = "{id}")
    private VendorType getVendorTypeByID(@PathVariable("id") UUID id) {
        return this.vendorService.getVendorTypeByID(id).orElse(new VendorType());
    }

}
