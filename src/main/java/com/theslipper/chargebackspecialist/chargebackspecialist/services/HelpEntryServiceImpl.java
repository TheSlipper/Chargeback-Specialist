package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.HelpEntry;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.HelpEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HelpEntryServiceImpl implements HelpEntryService {

    @Autowired
    private HelpEntryRepository helpEntryRepository;

    @Override
    public Iterable<HelpEntry> getAllHelpEntries() {
        return this.helpEntryRepository.findAll();
    }

    @Override
    public Optional<HelpEntry> getHelpEntryByID(UUID uuid) {
        return this.helpEntryRepository.findById(uuid);
    }

    @Override
    public void deleteHelpEntryByID(UUID uuid) {
        this.helpEntryRepository.deleteById(uuid);
    }

    @Override
    public void addHelpEntry(HelpEntry helpEntry) {
        this.helpEntryRepository.save(helpEntry);
    }

    @Override
    public boolean hasHelpEntries() {
        return this.helpEntryRepository.findAll().iterator().hasNext();
    }
}
