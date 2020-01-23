package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VendorRepository extends CrudRepository<Vendor, UUID> {
}
