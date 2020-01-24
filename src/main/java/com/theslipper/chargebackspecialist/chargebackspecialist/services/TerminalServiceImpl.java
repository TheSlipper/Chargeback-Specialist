package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Terminal;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.TerminalModelRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalModelRepository terminalModelRepository;

    @Autowired
    private TerminalRepository terminalRepository;

    @Override
    public void addTerminalModel(TerminalModel tm) {
        terminalModelRepository.save(tm);
    }

    @Override
    public void rmTerminalModelByID(UUID id) {
        terminalModelRepository.deleteById(id);
    }

    @Override
    public Iterable<TerminalModel> getAllTerminalModels() {
        return terminalModelRepository.findAll();
    }

    @Override
    public Optional<TerminalModel> getTerminalModelByID(UUID id) {
        return terminalModelRepository.findById(id);
    }

    @Override
    public void addTerminal(Terminal terminal) {
        terminalRepository.save(terminal);
    }

    @Override
    public void rmTerminalByID(UUID id) {
        terminalRepository.deleteById(id);
    }

    @Override
    public Iterable<Terminal> getAllTerminals() {
        return terminalRepository.findAll();
    }

    @Override
    public Optional<Terminal> getTerminalByID(UUID id) {
        return terminalRepository.findById(id);
    }
}
