package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Update;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateRepository updateRepository;

    @Override
    public void addUpdate(Update update) {
        this.updateRepository.save(update);
    }

    @Override
    public void rmUpdateByID(UUID id) {
        this.updateRepository.deleteById(id);
    }

    @Override
    public Iterable<Update> getAllUpdates() {
        return this.updateRepository.findAll();
    }

    @Override
    public Optional<Update> getUpdateByID(UUID id) {
        return this.updateRepository.findById(id);
    }
}
