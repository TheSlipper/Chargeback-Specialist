package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.HelpEntry;

import java.util.Optional;
import java.util.UUID;

public interface HelpEntryService {
    Iterable<HelpEntry> getAllHelpEntries();
    Optional<HelpEntry> getHelpEntryByID(UUID uuid);
    void deleteHelpEntryByID(UUID uuid);
    void addHelpEntry(HelpEntry helpEntry);
}
