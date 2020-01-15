package com.theslipper.chargebackspecialist.chargebackspecialist.model;

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

    public enum vendorPrivilege {
            // TODO:
    }

}
