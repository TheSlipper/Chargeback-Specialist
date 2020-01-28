package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.HelpEntry;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.HelpEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/helpentry")
@RestController
public class HelpEntryController {

    private final HelpEntryService helpEntryService;

    @Autowired
    public HelpEntryController(HelpEntryService helpEntryService) {
        this.helpEntryService = helpEntryService;
    }

    @PutMapping
    private void addHelpEntry(@RequestBody HelpEntry helpEntry) {
        this.helpEntryService.addHelpEntry(helpEntry);
    }

    @DeleteMapping(path = "{id}")
    private void deleteByID(@PathVariable("id") UUID uuid) {
        // TODO: Change deleteHelpEntryByID to rmEntry...
        this.helpEntryService.deleteHelpEntryByID(uuid);
    }

    @GetMapping(path = "{id}")
    private HelpEntry getHelpEntryByID(@PathVariable("id") UUID uuid) {
        return this.helpEntryService.getHelpEntryByID(uuid).orElse(new HelpEntry());
    }

    @GetMapping
    private Iterable<HelpEntry> getAllHelpEntries() {
        return this.helpEntryService.getAllHelpEntries();
    }
}
