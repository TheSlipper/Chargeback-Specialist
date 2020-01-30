package com.theslipper.chargebackspecialist.chargebackspecialist.services;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.SystemUserRepository;
import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.SystemUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public void editSystemUser(SystemUser systemUser) {
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
    public Page<SystemUser> getSystemUsersFromPage(int pageNo) {
        Page<SystemUser> users = systemUserRepository.findAll(PageRequest.of(pageNo, 5));
        return users;
    }

    @Override
    public boolean isPageEmpty(int pageNo) {
        Page<SystemUser> users = systemUserRepository.findAll(PageRequest.of(pageNo, 5));
        return users.getTotalPages() <= pageNo;
    }

    @Override
    public Optional<SystemUser> getSystemUserByID(UUID id) {
        return this.systemUserRepository.findById(id);
    }

    @Override
    public Iterable<SystemUser> getSystemUsersByName(String name, int pageNo) {
        return this.systemUserRepository.
                findAllBySystemUserName(name, PageRequest.of(pageNo, 5));
    }

    @Override
    public Iterable<SystemUser> getSystemUsersBySurname(String surname, int pageNo) {
        return this.systemUserRepository.
                findAllBySystemUserSurname(surname, PageRequest.of(pageNo, 5));
    }

    @Override
    public Iterable<SystemUser> getSystemUsersByEmail(String email, int pageNo) {
        return this.systemUserRepository.
                findAllBySystemUserEmail(email, PageRequest.of(pageNo, 5));
    }

    @Override
    public Iterable<SystemUser> getSystemUsersByRole(SystemUserRole role, int pageNo) {
        return this.systemUserRepository.
                findAllBySystemUserRole(role, PageRequest.of(pageNo, 5));
    }

    @Override
    public boolean hasSystemUsers() {
        return this.systemUserRepository.findAll().iterator().hasNext();
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

    @Override
    public Iterable<SystemUserRole> getSystemUserRolesByName(String name) {
        return this.systemUserRoleRepository.findAllBySystemUserRoleName(name);
    }

    @Override
    public boolean hasSystemUserRoles() {
        return this.systemUserRoleRepository.findAll().iterator().hasNext();
    }
}
