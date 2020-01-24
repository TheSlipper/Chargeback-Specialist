package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.VendorType;

import java.util.Optional;
import java.util.UUID;

public interface VendorService {
    void addVendorType(VendorType vendorType);
    void rmVendorTypeByID(UUID id);
    Iterable<VendorType> getAllVendorTypes();
    Optional<VendorType> getVendorTypeByID(UUID id);
    Iterable<VendorType> getVendorTypesByName(String name);

    void addVendor(Vendor vendor);
    void rmVendorByID(UUID id);
    Iterable<Vendor> getAllVendors();
    Optional<Vendor> getVendorByID(UUID id);
    Iterable<Vendor> getVendorsByName(String name);
    Iterable<Vendor> getVIPVendors();
}
