package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name = "system_user_role_authority", nullable = false)
    private String authority;

    /**
     * Checks if the given role has permission to execute some specified action.
     * @param systemPermission specified action.
     * @return true when the role has the permissions.
     */
    public boolean hasPermission(SystemPermission systemPermission) {
        for (SystemPermission s : this.permissions) {
            if (s == systemPermission)
                    return true;
        }
        return false;
    }

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

    public SystemUserRole(@JsonProperty("systemUserRoleID") UUID systemUserRoleID,
                          @JsonProperty("systemUserRoleName") String systemUserRoleName,
                          @JsonProperty("systemPermissions") SystemPermission[] permissions,
                          @JsonProperty("authority") String authority) {
        this.systemUserRoleName = systemUserRoleName;
        this.permissions = permissions;
        this.systemUserRoleID = systemUserRoleID;
        this.authority = authority;
    }

    public SystemUserRole() {
    }

    public UUID getSystemUserRoleID() {
        return systemUserRoleID;
    }

    public void setSystemUserRoleID(UUID systemUserRoleID) {
        this.systemUserRoleID = systemUserRoleID;
    }

    public String getSystemUserRoleName() {
        return systemUserRoleName;
    }

    public void setSystemUserRoleName(String systemUserRoleName) {
        this.systemUserRoleName = systemUserRoleName;
    }

    public SystemPermission[] getPermissions() {
        return permissions;
    }

    public void setPermissions(SystemPermission[] permissions) {
        this.permissions = permissions;
    }
}
