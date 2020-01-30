package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public CardIssuer(@JsonProperty("issuerID") UUID issuerID,
                      @JsonProperty("cardIssuerName") String cardIssuerName,
                      @JsonProperty("productsSupported") boolean productsSupported) {
        this.issuerID = issuerID;
        this.cardIssuerName = cardIssuerName;
        this.productsSupported = productsSupported;
    }

    public CardIssuer() {
    }

    public UUID getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(UUID issuerID) {
        this.issuerID = issuerID;
    }

    public String getCardIssuerName() {
        return cardIssuerName;
    }

    public void setCardIssuerName(String cardIssuerName) {
        this.cardIssuerName = cardIssuerName;
    }

    public boolean isProductsSupported() {
        return productsSupported;
    }

    public void setProductsSupported(boolean productsSupported) {
        this.productsSupported = productsSupported;
    }

    public String toString() {
        return "Issuer ID: " + this.issuerID + "\nIssuer Name: " + this.cardIssuerName +
                "\nProduct Supported: " + this.productsSupported;
    }
}
