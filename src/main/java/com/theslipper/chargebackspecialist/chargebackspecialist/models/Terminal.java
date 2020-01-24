package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/** Represents vendor's terminal used for processing the transactions. */
@Entity
@Table(name = "terminals")
public class Terminal {
    /** ID of the terminal. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "terminal_id", updatable = false, nullable = false)
    private UUID terminalID;

    /** Name of the terminal. */
    @Column(name = "terminal_name", updatable = false, nullable = false)
    private String terminalName;

    /** Date at which the terminal has been set up. */
    @Column(name = "terminal_set_up_date", updatable = false, nullable = false)
    private Date terminalSetUpDate;

    /** Date at which the contract expires and when the terminal will be shut down (Can be modified if the client
     * doesn't sign a new contract and doesn't return the terminal).
     */
    @Column(name = "terminal_lease_expiry_date", nullable = false)
    private Date terminalLeaseExpiryDate;

    /** Model of the terminal from the company's lineup. */
    @ManyToOne
    private TerminalModel terminalModel;

    /** The vendor to whom the terminal belongs. */
    @ManyToOne
    private Vendor terminalVendor;

    public Terminal(@JsonProperty("terminalID") UUID terminalID, @JsonProperty("terminalName") String terminalName,
                    @JsonProperty("terminalSetUpDate") Date terminalSetUpDate,
                    @JsonProperty("terminalLeaseExpiryDate") Date terminalLeaseExpiryDate,
                    @JsonProperty("terminalModel") TerminalModel terminalModel,
                    @JsonProperty("terminalVendor") Vendor terminalVendor) {
        this.terminalID = terminalID;
        this.terminalName = terminalName;
        this.terminalSetUpDate = terminalSetUpDate;
        this.terminalLeaseExpiryDate = terminalLeaseExpiryDate;
        this.terminalModel = terminalModel;
        this.terminalVendor = terminalVendor;
    }

    public Terminal() {

    }

    public UUID getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(UUID terminalID) {
        this.terminalID = terminalID;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Date getTerminalSetUpDate() {
        return terminalSetUpDate;
    }

    public void setTerminalSetUpDate(Date terminalSetUpDate) {
        this.terminalSetUpDate = terminalSetUpDate;
    }

    public Date getTerminalLeaseExpiryDate() {
        return terminalLeaseExpiryDate;
    }

    public void setTerminalLeaseExpiryDate(Date terminalLeaseExpiryDate) {
        this.terminalLeaseExpiryDate = terminalLeaseExpiryDate;
    }

    public TerminalModel getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(TerminalModel terminalModel) {
        this.terminalModel = terminalModel;
    }

    public Vendor getTerminalVendor() {
        return terminalVendor;
    }

    public void setTerminalVendor(Vendor terminalVendor) {
        this.terminalVendor = terminalVendor;
    }
}
