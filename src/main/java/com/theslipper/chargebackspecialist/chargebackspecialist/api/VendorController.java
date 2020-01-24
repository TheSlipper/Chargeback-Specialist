package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/vendor")
@RestController
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PutMapping
    private void addVendor(@RequestBody Vendor vendor) {
        this.vendorService.addVendor(vendor);
    }

    @DeleteMapping(path = "{id}")
    private void rmVendor(@PathVariable("id") UUID id) {
        this.vendorService.rmVendorByID(id);
    }

    @GetMapping
    private Iterable<Vendor> getAllVendors() {
        return this.vendorService.getAllVendors();
    }

    @GetMapping(path = "{id}")
    private Vendor getVendorByID(UUID id) {
        return this.vendorService.getVendorByID(id).orElse(new Vendor());
    }

}
