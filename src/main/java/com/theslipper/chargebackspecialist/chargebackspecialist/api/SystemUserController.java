package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/systemuser")
@RestController
public class SystemUserController {

    private final SystemUserService systemUserService;

    @Autowired
    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PutMapping
    private void addSystemUser(@RequestBody SystemUser user) {
        this.systemUserService.addSystemUser(user);
    }

    @DeleteMapping(path = "{id}")
    private void deleteSystemUserByID(@PathVariable("id") UUID id) {
        systemUserService.rmSystemUserByID(id);
    }

    @GetMapping
    private Iterable<SystemUser> getSystemUsers() {
        return systemUserService.getAllSystemUsers();
    }

    @GetMapping(path = "{id}")
    private SystemUser getSystemUserByID(@PathVariable("id") UUID id) {
        return systemUserService.getSystemUserByID(id).orElse(new SystemUser());
    }
}
