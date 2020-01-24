package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;

import java.util.Optional;
import java.util.UUID;

public interface SystemUserService {
    void addSystemUser(SystemUser systemUser);
    void rmSystemUserByID(UUID id);
    Iterable<SystemUser> getAllSystemUsers();
    Optional<SystemUser> getSystemUserByID(UUID id);

    void addSystemUserRole(SystemUserRole systemUserRole);
    void rmSystemUserRoleByID(UUID id);
    Iterable<SystemUserRole> getAllSystemUserRoles();
    Optional<SystemUserRole> getSystemUserRoleByID(UUID id);
}
