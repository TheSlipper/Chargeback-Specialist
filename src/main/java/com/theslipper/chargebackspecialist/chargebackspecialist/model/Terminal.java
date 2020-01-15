package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import java.util.Date;
import java.util.UUID;

/** Represents vendor's terminal used for processing the transactions. */
public class Terminal {
    /** ID of the terminal. */
    private UUID terminalID;

    /** Name of the terminal. */
    private String terminalName;

    /** Date at which the terminal has been set up. */
    private Date setUpDate;

    /** Date at which the contract expires and when the terminal will be shut down (Can be modified if the client
     * doesn't sign a new contract and doesn't return the terminal).
     */
    private Date leaseExpiryDate;

    /** ID of the terminal's model. */
    private UUID terminalModelID;

    /** ID of the vendor that uses this terminal. */
    private UUID vendorID;

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

    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }

    public Date getLeaseExpiryDate() {
        return leaseExpiryDate;
    }

    public void setLeaseExpiryDate(Date leaseExpiryDate) {
        this.leaseExpiryDate = leaseExpiryDate;
    }

    public UUID getTerminalModelID() {
        return terminalModelID;
    }

    public void setTerminalModelID(UUID terminalModelID) {
        this.terminalModelID = terminalModelID;
    }

    public UUID getVendorID() {
        return vendorID;
    }

    public void setVendorID(UUID vendorID) {
        this.vendorID = vendorID;
    }
}
