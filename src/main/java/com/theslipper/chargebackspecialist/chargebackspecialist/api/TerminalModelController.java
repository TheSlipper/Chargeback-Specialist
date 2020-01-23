package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.TerminalModelRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/terminalmodel")
@RestController
public class TerminalModelController {

    private final TerminalService terminalService;

    @Autowired
    public TerminalModelController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @PutMapping
    private void addTerminalModel(@RequestBody TerminalModel tm) {
        terminalService.addTerminalModel(tm);
    }

    // TODO: Test
    @DeleteMapping(path = "{id}")
    private void removeTerminalModel(@PathVariable("id") UUID id) {
        terminalService.rmTerminalModelByID(id);
    }

    // TODO: Test
    @GetMapping
    private Iterable<TerminalModel> getTerminalModels() {
        Iterable<TerminalModel> test = terminalService.getAllTerminalModels();
        return test;
    }

    // TODO: Test
    @GetMapping(path = "{id}")
    private TerminalModel getTerminalModel(@PathVariable("id") UUID id) {
        return terminalService.getTerminalModelByID(id).orElse(new TerminalModel());
    }
}
