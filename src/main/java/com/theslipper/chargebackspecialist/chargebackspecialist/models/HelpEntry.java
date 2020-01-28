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

    @Column(name = "help_entry_header", nullable = false)
    private String header;

    @Column(name = "help_entry_body", nullable = false)
    private String body;

    public HelpEntry(@JsonProperty("helpEntryID") UUID helpEntryID,
                     @JsonProperty("header") String header,
                     @JsonProperty("body") String body) {
        this.helpEntryID = helpEntryID;
        this.header = header;
        this.body = body;
    }

    public HelpEntry() {
    }

    public UUID getHelpEntryID() {
        return helpEntryID;
    }

    public void setHelpEntryID(UUID helpEntryID) {
        this.helpEntryID = helpEntryID;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
