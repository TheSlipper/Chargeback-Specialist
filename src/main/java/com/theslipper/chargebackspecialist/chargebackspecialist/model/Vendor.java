package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import java.util.UUID;

/** Represents a vendor. */
public class Vendor {
    /** Vendor's ID. */
    private UUID vendorID;

    /** Vendor's name. */
    private String vendorName;

    /**
     * Identifies what contract the vendor has signed with our company and how important he is for us.
     */
    private VendorType vendorType;

    public UUID getVendorID() {
        return vendorID;
    }

    public void setVendorID(UUID vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }

    enum VendorType {
        Standard,
        Exclusive,
        VIP
    }
}
