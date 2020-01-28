package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/** Represents an owner of a card that is related to a chargeback case. */
@Entity
@Table(name = "card_holders")
public class CardHolder {
    /** This system's ID for the card holder. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "card_holder_id", updatable = false, nullable = false)
    private UUID cardHoldersID;

    /** Represents the country that the card holder is from. */
    @Column(name = "card_holder_country", updatable = false, nullable = false)
    private String cardHoldersCountry;

    /** Card holder's card number. */
    @Column(name = "card_holder_card_number", updatable = false, nullable = false)
    private String cardholdersCardNumber;

    /** Card holder's first name. */
    @Column(name = "card_holder_first_name", updatable = false, nullable = false)
    private String cardholdersFirstName;

    /** Card holder's surname. */
    @Column(name = "card_holder_surname", updatable = false, nullable = false)
    private String cardHoldersSurname;

    /** The card issuer of the card holder. */
    @ManyToOne
    private CardIssuer cardIssuer;

    public CardHolder(@JsonProperty("cardHoldersID") UUID cardHoldersID,
                      @JsonProperty("cardHoldersCountry") String cardHoldersCountry,
                      @JsonProperty("cardholdersCardNumber") String cardholdersCardNumber,
                      @JsonProperty("cardholdersFirstName") String cardholdersFirstName,
                      @JsonProperty("cardholdersSurname") String cardHoldersSurname,
                      @JsonProperty("cardIssuer") CardIssuer cardIssuer) {
        this.cardHoldersID = cardHoldersID;
        this.cardHoldersCountry = cardHoldersCountry;
        this.cardholdersCardNumber = cardholdersCardNumber;
        this.cardholdersFirstName = cardholdersFirstName;
        this.cardHoldersSurname = cardHoldersSurname;
    }

    public CardHolder() {
    }

    public UUID getCardHoldersID() {
        return cardHoldersID;
    }

    public void setCardHoldersID(UUID cardHoldersID) {
        this.cardHoldersID = cardHoldersID;
    }

    public String getCardHoldersCountry() {
        return cardHoldersCountry;
    }

    public void setCardHoldersCountry(String cardHoldersCountry) {
        this.cardHoldersCountry = cardHoldersCountry;
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

    public String getCardHoldersSurname() {
        return cardHoldersSurname;
    }

    public void setCardHoldersSurname(String cardholdersSurname) {
        this.cardHoldersSurname = cardholdersSurname;
    }

    public CardIssuer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    @Override
    public String toString() {
        return "Cardholder ID: " + this.cardHoldersID + "\nFirst Name: " + this.cardholdersFirstName + "\nSurname: "
                + this.cardHoldersSurname + "\nCountry: " + this.cardHoldersCountry + "\nCard Number: ************" +
                this.cardholdersCardNumber.substring(12) + "\nCard Issuer: " + this.cardIssuer;
    }
}
