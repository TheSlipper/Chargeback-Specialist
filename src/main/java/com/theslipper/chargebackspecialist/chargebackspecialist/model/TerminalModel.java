package com.theslipper.chargebackspecialist.chargebackspecialist.model;

import java.util.UUID;

/** Represents a model of the issued terminal. */
public class TerminalModel {

    /** ID of the given model. */
    private UUID terminalModelID;

    /** Name of the terminal model. */
    private String modelName;

    private TerminalModel() {}

    public TerminalModel(UUID terminalModelID, String modelName) {
        this.terminalModelID = terminalModelID;
        this.modelName = modelName;
    }

    public UUID getTerminalModelID() {
        return terminalModelID;
    }

    public String getModelName() {
        return modelName;
    }
}
