package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

// TODO: Rename chargebackspecialist.chargebackspecialist.model -> chargebackspecialist.model
/** Represents a single chargeback entry. */
@Entity
@Table(name = "chargebacks")
public class Chargeback {

    /** Card issuer's ID of the chargeback process for this transaction. */
    @Column(name = "chargebackProcessID", updatable = false, nullable = false)
    private UUID chargebackProcessID;

    /**
     * Internal ID of the chargeback. When the current stage of chargeback finishes Chargeback objects gets copied, has this value and the stage changed and submitted to database.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "chargebackEntryID", updatable = false, nullable = false)
    private UUID chargebackEntryID;

    /** Code that represents the current stage of the chargeback.*/
    @Enumerated(EnumType.STRING)
    private ChargebackCode chargebackCode;

    /** The date of card holder's chargeback submission. */
    private Date chargebackSubmitDate;

    /** The date at which the chargeback case was opened in chargeback specialist. */
    private Date chargebackOpenedDate;

    /** The date at which the chargeback case was processed. */
    private Date chargebackProcessedDate;

    /** ID of the concerned card holder. */
    private UUID cardHolderID;

    /** ID of the concerned vendor. */
    private UUID vendorID;

    public Chargeback() {

    }

    public Chargeback(UUID chargebackProcessID, UUID chargebackEntryID, ChargebackCode chargebackCode, Date chargebackSubmitDate, Date chargebackOpenedDate, Date chargebackProcessedDate, UUID cardHolderID, UUID vendorID) {
        this.chargebackProcessID = chargebackProcessID;
        this.chargebackEntryID = chargebackEntryID;
        this.chargebackCode = chargebackCode;
        this.chargebackSubmitDate = chargebackSubmitDate;
        this.chargebackOpenedDate = chargebackOpenedDate;
        this.chargebackProcessedDate = chargebackProcessedDate;
        this.cardHolderID = cardHolderID;
        this.vendorID = vendorID;
    }

    public UUID getChargebackProcessID() {
        return chargebackProcessID;
    }

    public void setChargebackProcessID(UUID chargebackID) {
        this.chargebackProcessID = chargebackID;
    }

    public UUID getChargebackEntryID() {
        return chargebackEntryID;
    }

    public void setChargebackEntryID(UUID chargebackEntryID) {
        this.chargebackEntryID = chargebackEntryID;
    }

    public ChargebackCode getChargebackCode() {
        return chargebackCode;
    }

    public void setChargebackCode(ChargebackCode chargebackCode) {
        this.chargebackCode = chargebackCode;
    }

    public Date getChargebackSubmitDate() {
        return chargebackSubmitDate;
    }

    public void setChargebackSubmitDate(Date chargebackSubmitDate) {
        this.chargebackSubmitDate = chargebackSubmitDate;
    }

    public Date getChargebackOpenedDate() {
        return chargebackOpenedDate;
    }

    public void setChargebackOpenedDate(Date chargebackOpenedDate) {
        this.chargebackOpenedDate = chargebackOpenedDate;
    }

    public Date getChargebackProcessedDate() {
        return chargebackProcessedDate;
    }

    public void setChargebackProcessedDate(Date chargebackProcessedDate) {
        this.chargebackProcessedDate = chargebackProcessedDate;
    }

    public UUID getCardHolderID() {
        return cardHolderID;
    }

    public void setCardHolderID(UUID cardHolderID) {
        this.cardHolderID = cardHolderID;
    }

    public UUID getVendorID() {
        return vendorID;
    }

    public void setVendorID(UUID vendorID) {
        this.vendorID = vendorID;
    }

    public enum ChargebackCode {
        // >>>>>>>>>>>>>>>> VISA <<<<<<<<<<<<<<<<
        // https://chargebacks911.com/chargeback-reason-codes/visa/

        // Fraud
        EMV_LIABILITY_SHIFT_COUNTERFEIT_FRAUD, // 10.1
        EMV_LIABILITY_SHIT_NON_COUNTERFEIT_FRAUD, // 10.2
        OTHER_FRAUD_CARD_PRESENT_ENVIRONMENT, // 10.3
        OTHER_FRAUD_CARD_ABSENT_ENVIRONMENT, // 10.4
        VISA_FRAUD_MONITORING_PROGRAM, // 10.5

        // Authorization
        CARD_RECOVERY_BULLETIN, // 11.1
        DECLINED_AUTHORIZATION, // 11.2
        NO_AUTHORIZATION, // 11.3

        // Processing errors
        VISA_LATE_PRESENTMENT, // 12.1
        INCORRECT_TRANSACTION_CODE, // 12.2
        INCORRECT_CURRENCY, // 12.3
        INCORRECT_ACCOUNT_NUMBER, // 12.4
        INCORRECT_AMOUNT, // 12.5
        DUPLICATE_PROCESSING_PAID_BY_OTHER_MEANS, // 12.6
        INVALID_DATA, // 12.7

        // Customer disputes
        MERCHANDISE_OR_SERVICES_NOT_RECEIVED, // 13.1
        CANCELED_RECURRING_TRANSACTION, // 13.2
        NOT_AS_DESCRIBED_OR_DEFECTIVE_MERCHANDISE_OR_SERVICES, // 13.3
        COUNTERFEIT_MERCHANDISE, // 13.4
        MISREPRESENTATION, // 13.5
        VISA_CREDIT_NOT_PROCESSED, // 13.6
        CANCELLED_MERCHANDISE_OR_SERVICES, // 13.7
        ORIGINAL_CREDIT_TRANSACTION_NOT_ACCEPTED, // 13.8
        NON_RECEIPT_OF_CASH_OR_LOAD_TRANSACTION_VALUE, // 13.9


        // >>>>>>>>>>>>>>>> MASTERCARD <<<<<<<<<<<<<<<<
        // https://chargebacks911.com/chargeback-reason-codes/mastercard/

        // Authorization
        WARNING_BULLETIN_FILE, // 4807
        AUTHORIZATION_RELATED_CHARGEBACK, // 4808
        ACCOUNT_NUMBER_NOT_ON_FILE, // 4812

        // Cardholder dispute
        CANCELED_RECURRING_OR_DIGITAL_GOODS_TRANSACTIONS, // 4841
        CARDHOLDER_DISPUTE, // 4853
        CARDHOLDER_DISPUTE_NOT_ELSEWHERE_CLASSIFIED, // 4854
        GOODS_OR_SERVICES_NOT_PROVIDED, // 4855
        NO_SHOW_APPENDUM_ATM_DISPUTE, // 4859
        MC_CREDIT_NOT_PROCESSED, // 4860

        // Fraud
        NO_CARDHOLDER_AUTHORIZATION, // 4837
        FRAUDULENT_PROCESSING_OF_TRANSACTIONS, // 4840
        QUESTIONABLE_MERCHANT_ACTIVITY, // 4849
        CARDHOLDER_DOES_NOT_RECOGNIZE_POTENTIAL_FRAUD, // 4863
        CHIP_LIABILITY_SHIFT, // 4870
        CHIP_OR_PIN_LIABILITY_SHIFT_OR_STOLEN_OR_NEVER_RECEIVED_ISSUE_NRI_FRAUD, // 4871

        // Point-Of-Interactions Errors
        TRANSACTION_AMOUNT_DIFFERS, // 4831
        POINT_OF_INTERACTION_ERROR, // 4834
        MC_LATE_PRESENTMENT, // 4842
        INCORRECT_CURRENCY_CODE // 4846
        // TODO: If necessary make AMEX and DISCOVER chargeback support as well
    }
}
