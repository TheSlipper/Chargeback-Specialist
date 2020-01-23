package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.TerminalModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TerminalModelRepository extends CrudRepository<TerminalModel, UUID> {
}
