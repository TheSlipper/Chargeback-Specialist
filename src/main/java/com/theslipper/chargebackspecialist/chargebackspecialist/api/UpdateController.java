package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.Update;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/update")
@RestController
public class UpdateController {

    private final UpdateService updateService;

    @Autowired
    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping
    private void addUpdate(Update update) {
        this.updateService.addUpdate(update);
    }

    @DeleteMapping
    private void deleteUpdateByID(UUID id) {
        this.updateService.rmUpdateByID(id);
    }

    @GetMapping
    private Iterable<Update> getUpdates() {
        return updateService.getAllUpdates();
    }

    @GetMapping(path = "{id}")
    private Update getUpdateByID(@PathVariable("id") UUID id) {
        return updateService.getUpdateByID(id).orElse(new Update());
    }
}
