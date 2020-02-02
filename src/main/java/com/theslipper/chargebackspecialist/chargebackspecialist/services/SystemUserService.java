package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import org.springframework.data.domain.Page;

import java.util.List;
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
    List<SystemUser> getSystemUsersByLogin(String login);
    boolean hasSystemUsers();

    void addSystemUserRole(SystemUserRole systemUserRole);
    void rmSystemUserRoleByID(UUID id);
    Iterable<SystemUserRole> getAllSystemUserRoles();
    Optional<SystemUserRole> getSystemUserRoleByID(UUID id);
    Iterable<SystemUserRole> getSystemUserRolesByName(String name);
    boolean hasSystemUserRoles();

    List<SystemUser> getSystemUsersByEmail(String eMail);
}
