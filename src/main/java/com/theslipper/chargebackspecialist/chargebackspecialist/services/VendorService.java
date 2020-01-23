package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.VendorType;

import java.util.List;
import java.util.UUID;

public interface VendorService {
    List<VendorType> getAllVendorTypes();
    List<Vendor> getAllVendors();

    VendorType getVendorTypeByID(UUID id);
    Vendor getVendorByID(UUID id);

    VendorType getVendorTypeByName(String name);
    Vendor getVendorByName(String name);

    List<Vendor> getVIPVendors();
}
