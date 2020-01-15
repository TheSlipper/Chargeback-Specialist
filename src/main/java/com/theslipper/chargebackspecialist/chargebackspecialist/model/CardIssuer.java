package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/** Represents the institution that issues credit or debit cards. */
@Entity
@Table(name = "card_issuers")
public class CardIssuer {
    /** Unique ID of the issuer. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "card_issuer_id", updatable = false, nullable = false)
    private UUID issuerID;

    /** Name of the issuer. */
    @Column(name = "card_issuer_name", nullable = false)
    private String cardIssuerName;

    /** Flag that determines whether we support the companies cards. */
    @Column(name = "card_issuer_support", nullable = false)
    private boolean productsSupported;
}
