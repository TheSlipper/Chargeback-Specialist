package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/** Represents a role of a user in system. */
@Entity
@Table(name = "system_user_roles")
public class SystemUserRole {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "system_user_role_id", updatable = false, nullable = false)
    private UUID systemUserRoleID;

    @Column(name = "system_user_role_name", updatable = false, nullable = false)
    private String systemUserRoleName;

    @Enumerated(EnumType.STRING)
    @Lob
    @Column(name = "system_user_role_permissions", updatable = false, nullable = false)
    private SystemPermission[] permissions;

    public enum SystemPermission {
        ADD_USER,
        DELETE_USER,
        EDIT_USER,
        PROCESS_VISA_CHARGEBACK,
        PROCESS_MASTERCARD_CHARGEBACK,
        SEND_UPDATE_MESSAGE,
        DELETE_UPDATE_MESSAGE,
        EDIT_UPDATE_MESSAGE
    }
}
