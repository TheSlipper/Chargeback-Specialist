package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "help_entries")
public class HelpEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "help_entry_id", updatable = false, nullable = false)
    private UUID helpEntryID;

    @Column(name = "help_entry_name", nullable = false)
    private String name;

    @Column(name = "help_entry_description", nullable = false, length = 1000)
    private String description;

    @Column(name = "help_entry_time_limit", nullable = false)
    private int timeLimit;

    @Column(name = "help_entry_typical_causes", length = 1000)
    private String typicalCauses;

    @Column(name = "help_entry_prevention_steps", length = 1000)
    private String preventionSteps;

    public HelpEntry(@JsonProperty("helpEntryID") UUID helpEntryID,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("timeLimit") int timeLimit,
                     @JsonProperty("typicalCauses") String typicalCauses,
                     @JsonProperty("preventionSteps") String preventionSteps) {
        this.helpEntryID = helpEntryID;
        this.name = name;
        this.description = description;
        this.timeLimit = timeLimit;
        this.typicalCauses = typicalCauses;
        this.preventionSteps = preventionSteps;
    }

    public HelpEntry() {
    }

    public UUID getHelpEntryID() {
        return helpEntryID;
    }

    public void setHelpEntryID(UUID helpEntryID) {
        this.helpEntryID = helpEntryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getTypicalCauses() {
        return typicalCauses;
    }

    public void setTypicalCauses(String typicalCauses) {
        this.typicalCauses = typicalCauses;
    }

    public String getPreventionSteps() {
        return preventionSteps;
    }

    public void setPreventionSteps(String preventionSteps) {
        this.preventionSteps = preventionSteps;
    }
}
