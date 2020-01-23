package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/** Represents a user of this system. */
@Entity
@Table(name = "system_users")
public class SystemUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "system_user_id", updatable = false, nullable = false)
    private UUID systemUserID;

    @Column(name = "system_user_name", updatable = false, nullable = false)
    private String systemUserName;

    @Column(name = "system_user_surname", updatable = false, nullable = false)
    private String systemUserSurname;

    @Column(name = "system_user_email", nullable = false)
    private String systemUserEmail;

    @Column(name = "system_user_login", nullable = false)
    private String systemUserLogin;

    @Column(name = "system_user_password", nullable = false)
    private String systemUserPassword;

    @Column(name = "system_user_account_creation_date", nullable = false)
    private Date systemUserAccountCreationDate;

    @Column(name = "system_user_password_refresh_date")
    private Date systemUserPasswordRefreshDate;

    @Lob
    @OneToMany
    @OrderColumn(name = "system_user_created_updates")
    private Update[] systemUserCreatedUpdates;

    @Lob
    @OneToMany
    @OrderColumn(name = "system_user_edited_updates")
    private Update[] systemUserEditedUpdates;

    @Lob
    @ManyToMany
    @OrderColumn(name = "system_user_roles")
    private SystemUserRole[] systemUserRoles;

}
