package com.theslipper.chargebackspecialist.chargebackspecialist.models;

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
//    @Column(name = "update_creator", updatable = false, nullable = false)
    private SystemUser updateCreator;

    @ManyToOne
//    @Column(name = "update_editor", updatable = false, nullable = false)
    private SystemUser updateEditor;

    @Column(name = "update_edition_date")
    private Date updateEditionDate;

    @Column(name = "update_header", nullable = false)
    private String updateHeader;

    @Column(name = "update_content", nullable = false)
    private String updateContent;

}
