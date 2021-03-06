package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/** Represents a vendor. */
@Entity
@Table(name = "vendors")
public class Vendor {
    /** Vendor's ID. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vendor_id", updatable = false, nullable = false)
    private UUID vendorID;

    /** Vendor's name. */
    @Column(name = "vendor_name", updatable = false, nullable = false)
    private String vendorName;

    /**
     * Identifies what contract the vendor has signed with our company and how important he is for us.
     */
    @ManyToOne
    private VendorType vendorType;

    public Vendor() {

    }

    public Vendor(@JsonProperty("vendorID") UUID vendorID,
                  @JsonProperty("vendorName") String vendorName,
                  @JsonProperty("vendorType") VendorType vendorType) {
        this.vendorName = vendorName;
        this.vendorType = vendorType;
        this.vendorID = vendorID;
    }

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

    public String toString() {
        return "Vendor ID: " + this.vendorID + "\nVendor Type: " + this.vendorType.toString() +
                "\nVendor Name: " + this.vendorName;
    }
}
