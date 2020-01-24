package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.SystemUserRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.SystemUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private SystemUserRoleRepository systemUserRoleRepository;

    @Override
    public void addSystemUser(SystemUser systemUser) {
        this.systemUserRepository.save(systemUser);
    }

    @Override
    public void rmSystemUserByID(UUID id) {
        this.systemUserRepository.deleteById(id);
    }

    @Override
    public Iterable<SystemUser> getAllSystemUsers() {
        return this.systemUserRepository.findAll();
    }

    @Override
    public Optional<SystemUser> getSystemUserByID(UUID id) {
        return this.systemUserRepository.findById(id);
    }

    @Override
    public void addSystemUserRole(SystemUserRole systemUserRole) {
        this.systemUserRoleRepository.save(systemUserRole);
    }

    @Override
    public void rmSystemUserRoleByID(UUID id) {
        this.systemUserRoleRepository.deleteById(id);
    }

    @Override
    public Iterable<SystemUserRole> getAllSystemUserRoles() {
        return this.systemUserRoleRepository.findAll();
    }

    @Override
    public Optional<SystemUserRole> getSystemUserRoleByID(UUID id) {
        return this.systemUserRoleRepository.findById(id);
    }
}
