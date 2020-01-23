package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.VendorType;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VendorTypeRepository extends CrudRepository<VendorType, UUID> {

}
