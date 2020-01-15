package com.theslipper.chargebackspecialist.chargebackspecialist.model;

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
    private Date terminalModelAcquisitionDate;

    /** Date at which the terminal will not be offered to the clients anymore. */
    @Column(name = "terminal_model_expiry_date")
    private Date terminalModelExpiryDate;

    /** Name of the terminal model. */
    @Column(name = "terminal_model_name", updatable = false, nullable = false)
    private String modelName;

    /** Specification of the terminal model that contains most of the important data. */
    @Column(name = "terminal_model_specification")
    private String modelSpecification;
}
