package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, UUID> {
    Page<SystemUser> findAllBySystemUserName(String name, Pageable pageable);
    Page<SystemUser> findAllBySystemUserSurname(String surname, Pageable pageable);
    Page<SystemUser> findAllBySystemUserEmail(String email, Pageable pageable);
    Page<SystemUser> findAllBySystemUserRole(SystemUserRole systemUserRole, Pageable pageable);
    List<SystemUser> findAllBySystemUserLogin(String login);
    List<SystemUser> findAllBySystemUserEmail(String email);
}
