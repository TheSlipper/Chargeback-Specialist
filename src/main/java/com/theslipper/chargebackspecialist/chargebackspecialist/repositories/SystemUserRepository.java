package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SystemUserRepository extends CrudRepository<SystemUser, UUID> {
}
