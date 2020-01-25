package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, UUID> {
}
