package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/** Represents a model of the issued terminal. */
@Entity
@Table(name = "terminal_models")
public class TerminalModel {

    /** ID of the given model. */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "terminal_model_id", updatable = false, nullable = false)
    private UUID terminalModelID;

    /** Date at which the company started offering this terminal model to the clients. */
    @Column(name = "terminal_model_acquisition_date", updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date terminalModelAcquisitionDate;

    /** Date at which the terminal will not be offered to the clients anymore. */
    @Column(name = "terminal_model_expiry_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date terminalModelExpiryDate;

    /** Name of the terminal model. */
    @Column(name = "terminal_model_name", updatable = false, nullable = false)
    private String modelName;

    /** Specification of the terminal model that contains most of the important data. */
    @Column(name = "terminal_model_specification")
    private String modelSpecification;

    public TerminalModel(@JsonProperty("terminalModelAcquisitionDate") Date terminalModelAcquisitionDate,
                         @JsonProperty("terminalModelExpiryDate") Date terminalModelExpiryDate,
                         @JsonProperty("modelName") String modelName,
                         @JsonProperty("modelSpecification") String modelSpecification) {
        this.terminalModelAcquisitionDate = terminalModelAcquisitionDate;
        this.terminalModelExpiryDate = terminalModelExpiryDate;
        this.modelName = modelName;
        this.modelSpecification = modelSpecification;
    }

    public TerminalModel() {
    }

    public UUID getTerminalModelID() {
        return terminalModelID;
    }

    public void setTerminalModelID(UUID terminalModelID) {
        this.terminalModelID = terminalModelID;
    }

    public Date getTerminalModelAcquisitionDate() {
        return terminalModelAcquisitionDate;
    }

    public void setTerminalModelAcquisitionDate(Date terminalModelAcquisitionDate) {
        this.terminalModelAcquisitionDate = terminalModelAcquisitionDate;
    }

    public Date getTerminalModelExpiryDate() {
        return terminalModelExpiryDate;
    }

    public void setTerminalModelExpiryDate(Date terminalModelExpiryDate) {
        this.terminalModelExpiryDate = terminalModelExpiryDate;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelSpecification() {
        return modelSpecification;
    }

    public void setModelSpecification(String modelSpecification) {
        this.modelSpecification = modelSpecification;
    }
}
