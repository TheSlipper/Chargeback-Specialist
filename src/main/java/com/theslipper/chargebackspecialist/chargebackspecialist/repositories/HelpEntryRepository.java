package com.theslipper.chargebackspecialist.chargebackspecialist.repositories;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.HelpEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface HelpEntryRepository extends PagingAndSortingRepository<HelpEntry, UUID> {
}
