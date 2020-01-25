package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/** Represents a user of this system. */
@Entity
@Table(name = "updates")
public class Update {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "update_id", updatable = false, nullable = false)
    private UUID updateID;

    @Column(name = "update_creation_date", updatable = false, nullable = false)
    private Date updateCreationDate;

    @ManyToOne
    private SystemUser updateCreator;

    @ManyToOne
    private SystemUser updateEditor;

    @Column(name = "update_edition_date")
    private Date updateEditionDate;

    @Column(name = "update_header", nullable = false)
    private String updateHeader;

    @Column(name = "update_content", nullable = false, columnDefinition = "TEXT")
    private String updateContent;

    public Update(@JsonProperty("updateID") UUID updateID,
                  @JsonProperty("updateCreationDate") Date updateCreationDate,
                  @JsonProperty("updateCreator") SystemUser updateCreator,
                  @JsonProperty("updateEditor") SystemUser updateEditor,
                  @JsonProperty("updateEditionDate") Date updateEditionDate,
                  @JsonProperty("updateHeader") String updateHeader,
                  @JsonProperty("updateContent") String updateContent) {
        // TODO: PUT update dummy data causes sql nested exception fix it
        this.updateID = updateID;
        this.updateCreationDate = updateCreationDate;
        this.updateCreator = updateCreator;
        this.updateEditor = updateEditor;
        this.updateEditionDate = updateEditionDate;
        this.updateHeader = updateHeader;
        this.updateContent = updateContent;
    }

    public Update() {
    }

    public UUID getUpdateID() {
        return updateID;
    }

    public void setUpdateID(UUID updateID) {
        this.updateID = updateID;
    }

    public Date getUpdateCreationDate() {
        return updateCreationDate;
    }

    public void setUpdateCreationDate(Date updateCreationDate) {
        this.updateCreationDate = updateCreationDate;
    }

    public SystemUser getUpdateCreator() {
        return updateCreator;
    }

    public void setUpdateCreator(SystemUser updateCreator) {
        this.updateCreator = updateCreator;
    }

    public SystemUser getUpdateEditor() {
        return updateEditor;
    }

    public void setUpdateEditor(SystemUser updateEditor) {
        this.updateEditor = updateEditor;
    }

    public Date getUpdateEditionDate() {
        return updateEditionDate;
    }

    public void setUpdateEditionDate(Date updateEditionDate) {
        this.updateEditionDate = updateEditionDate;
    }

    public String getUpdateHeader() {
        return updateHeader;
    }

    public void setUpdateHeader(String updateHeader) {
        this.updateHeader = updateHeader;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }
}
