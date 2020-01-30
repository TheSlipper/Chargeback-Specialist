package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Update;

import java.util.Optional;
import java.util.UUID;

public interface UpdateService {
    void addUpdate(Update update);
    void rmUpdateByID(UUID id);
    Iterable<Update> getAllUpdates();
    Optional<Update> getUpdateByID(UUID id);
    boolean hasUpdates();
}
