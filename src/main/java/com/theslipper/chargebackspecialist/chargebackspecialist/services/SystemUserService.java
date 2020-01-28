package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

public interface SystemUserService {
    void addSystemUser(SystemUser systemUser);
    void editSystemUser(SystemUser systemUser);
    void rmSystemUserByID(UUID id);
    Iterable<SystemUser> getAllSystemUsers();
    Page<SystemUser> getSystemUsersFromPage(int pageNo);
    boolean isPageEmpty(int pageNo);
    Optional<SystemUser> getSystemUserByID(UUID id);
    Iterable<SystemUser> getSystemUsersByName(String name, int pageNo);
    Iterable<SystemUser> getSystemUsersBySurname(String surname, int pageNo);
    Iterable<SystemUser> getSystemUsersByEmail(String email, int pageNo);
    Iterable<SystemUser> getSystemUsersByRole(SystemUserRole role, int pageNo);

    void addSystemUserRole(SystemUserRole systemUserRole);
    void rmSystemUserRoleByID(UUID id);
    Iterable<SystemUserRole> getAllSystemUserRoles();
    Optional<SystemUserRole> getSystemUserRoleByID(UUID id);
}
