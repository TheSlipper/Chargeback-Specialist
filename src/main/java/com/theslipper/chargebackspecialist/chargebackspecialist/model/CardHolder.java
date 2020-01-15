package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Locale;
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
    private String cardholdersSurname;

    /** The card issuer of the card holder. */
    @ManyToOne
    private CardIssuer cardIssuer;
}
