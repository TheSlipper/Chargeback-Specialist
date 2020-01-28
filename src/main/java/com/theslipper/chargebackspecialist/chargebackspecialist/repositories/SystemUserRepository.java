package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, UUID> {
    Iterable<SystemUser> findAllBySystemUserAccountCreationDate(Date date);

}
