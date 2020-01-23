package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Update;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UpdateRepository extends CrudRepository<Update, UUID> {

}
