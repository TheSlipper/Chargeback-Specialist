package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import java.util.UUID;

/** Represents the institution that issues credit or debit cards. */
public class CardIssuer {
    /** Unique ID of the issuer. */
    private UUID issuerID;

    /** Name of the issuer. */
    private String issuerName;

    /** Flag that determines whether we support the companies cards. */
    private boolean productsSupported;

    public CardIssuer(UUID issuerID, String issuerName, boolean productsSupported) {
        this.issuerID = issuerID;
        this.issuerName = issuerName;
        this.productsSupported = productsSupported;
    }

    public UUID getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(UUID issuerID) {
        this.issuerID = issuerID;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public boolean isProductsSupported() {
        return productsSupported;
    }

    public void setProductsSupported(boolean productsSupported) {
        this.productsSupported = productsSupported;
    }
}
