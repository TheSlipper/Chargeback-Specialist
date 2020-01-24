package com.theslipper.chargebackspecialist.chargebackspecialist.api;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/systemuserrole")
@RestController
public class SystemUserRoleController {

    private final SystemUserService systemUserService;

    @Autowired
    public SystemUserRoleController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PutMapping
    private void addSystemUserRole(@RequestBody SystemUserRole role) {
        this.systemUserService.addSystemUserRole(role);
    }

    @DeleteMapping(path = "{id}")
    private void deleteSystemUserRoleByID(@PathVariable("id") UUID id) {
        systemUserService.rmSystemUserRoleByID(id);
    }

    @GetMapping
    private Iterable<SystemUserRole> getSystemUserRoles() {
        return systemUserService.getAllSystemUserRoles();
    }

    @GetMapping(path = "{id}")
    private SystemUserRole getSystemUserRoleByID(@PathVariable("id") UUID id) {
        return systemUserService.getSystemUserRoleByID(id).orElse(new SystemUserRole());
    }
}
