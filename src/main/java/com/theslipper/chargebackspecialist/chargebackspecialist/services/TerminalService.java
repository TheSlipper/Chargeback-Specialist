package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;

import java.util.Optional;
import java.util.UUID;

public interface TerminalService {

    void addTerminalModel(TerminalModel tm);
    void rmTerminalModelByID(UUID id);

    Iterable<TerminalModel> getAllTerminalModels();
    Optional<TerminalModel> getTerminalModelByID(UUID id);
}
