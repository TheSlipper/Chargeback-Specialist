package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Terminal;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/terminal")
@RestController
public class TerminalController {

    private final TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @PutMapping
    private void addTerminal(@RequestBody Terminal terminal) {
        this.terminalService.addTerminal(terminal);
    }

    @DeleteMapping(path = "{id}")
    private void deleteTerminalByID(@PathVariable("id") UUID id) {
        terminalService.rmTerminalByID(id);
    }

    @GetMapping
    private Iterable<Terminal> getTerminals() {
        return terminalService.getAllTerminals();
    }

    @GetMapping(path = "{id}")
    private Terminal getTerminal(@PathVariable("id") UUID id) {
        return terminalService.getTerminalByID(id).orElse(new Terminal());
    }
}
