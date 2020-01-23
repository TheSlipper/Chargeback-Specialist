package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Terminal;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TerminalRepository extends CrudRepository<Terminal, UUID> {
}
