package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SystemUserRoleRepository extends CrudRepository<SystemUserRole, UUID> {
    Iterable<SystemUserRole> findAllBySystemUserRoleName(String name);
}
