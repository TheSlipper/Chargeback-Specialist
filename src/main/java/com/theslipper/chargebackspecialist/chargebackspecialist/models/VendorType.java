package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/** Type of the vendor. */
@Entity
@Table(name = "vendor_types")
public class VendorType {

    /** ID of the vendor type. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vendor_type_id", updatable = false, nullable = false)
    private UUID vendorTypeID;

    /** Name of the vendor type. */
    @Column(name = "vendor_type_name", updatable = false, nullable = false)
    private String vendorTypeName;

    /** Description of the vendor type. */
    @Column(name = "vendor_type_description")
    private String vendorTypeDescription;

    public VendorType() {
    }

    public VendorType(@JsonProperty("vendorTypeID") UUID id,
                      @JsonProperty("vendorTypeName") String vendorTypeName,
                      @JsonProperty("vendorTypeDescription") String vendorTypeDescription) {
        this.vendorTypeID = id;
        this.vendorTypeName = vendorTypeName;
        this.vendorTypeDescription = vendorTypeDescription;
    }

    public UUID getVendorTypeID() {
        return vendorTypeID;
    }

    public void setVendorTypeID(UUID vendorTypeID) {
        this.vendorTypeID = vendorTypeID;
    }

    public String getVendorTypeName() {
        return vendorTypeName;
    }

    public void setVendorTypeName(String vendorTypeName) {
        this.vendorTypeName = vendorTypeName;
    }

    public String getVendorTypeDescription() {
        return vendorTypeDescription;
    }

    public void setVendorTypeDescription(String vendorTypeDescription) {
        this.vendorTypeDescription = vendorTypeDescription;
    }

    public String toString() {
        return this.vendorTypeName;
    }
}
