package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.TerminalModelRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
