package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import java.util.Locale;
import java.util.UUID;

/** Represents an owner of a card that is related to a chargeback case. */
public class CardHolder {
    /** Represents the country that the card holder is from. */
    private String clientCountry;

    /** Card holder's card number. */
    private String cardholdersCardNumber;

    /** Card holder's first name. */
    private String cardholdersFirstName;

    /** Card holder's surname. */
    private String cardholdersSurname;

    /** ID of the card issuer that issued a card for this card holder. */
    private UUID cardIssuerID;

    public CardHolder(String country,
                      String cardholdersCardNumber,
                      String cardholdersFirstName,
                      String cardholdersSurname,
                      UUID cardIssuerID) {
        this.clientCountry = country;
        this.cardholdersCardNumber = cardholdersCardNumber;
        this.cardholdersFirstName = cardholdersFirstName;
        this.cardholdersSurname = cardholdersSurname;
        this.cardIssuerID = cardIssuerID;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getCardholdersCardNumber() {
        return cardholdersCardNumber;
    }

    public void setCardholdersCardNumber(String cardholdersCardNumber) {
        this.cardholdersCardNumber = cardholdersCardNumber;
    }

    public String getCardholdersFirstName() {
        return cardholdersFirstName;
    }

    public void setCardholdersFirstName(String cardholdersFirstName) {
        this.cardholdersFirstName = cardholdersFirstName;
    }

    public String getCardholdersSurname() {
        return cardholdersSurname;
    }

    public void setCardholdersSurname(String cardholdersSurname) {
        this.cardholdersSurname = cardholdersSurname;
    }

    public UUID getCardIssuerID() {
        return cardIssuerID;
    }

    public void setCardIssuerID(UUID cardIssuerID) {
        this.cardIssuerID = cardIssuerID;
    }
}
