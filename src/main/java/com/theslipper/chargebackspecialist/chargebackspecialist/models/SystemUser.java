package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public SystemUser() {

    }

    public SystemUser(@JsonProperty("systemUserName") String username,
                      @JsonProperty("systemUserSurname") String surname,
                      @JsonProperty("systemUserEmail") String email,
                      @JsonProperty("systemUserLogin") String login,
                      @JsonProperty("systemUserPassword") String password,
                      @JsonProperty("systemUserAccountCreationDate") Date systemUserAccountCreationDate,
                      @JsonProperty("systemUserPasswordRefreshDate") Date systemUserPasswordRefreshDate,
                      @JsonProperty("systemUserCreatedUpdates") Update[] systemUserCreatedUpdates,
                      @JsonProperty("systemUserEditedUpdates") Update[] systemUserEditedUpdates,
                      @JsonProperty("systemUserRoles") SystemUserRole[] systemUserRoles) {
        this.systemUserName = username;
        this.systemUserSurname = surname;
        this.systemUserEmail = email;
        this.systemUserLogin = login;
        this.systemUserPassword = password;
        this.systemUserAccountCreationDate = systemUserAccountCreationDate;
        this.systemUserPasswordRefreshDate = systemUserPasswordRefreshDate;
        this.systemUserCreatedUpdates = systemUserCreatedUpdates;
        this.systemUserEditedUpdates = systemUserEditedUpdates;
        this.systemUserRoles = systemUserRoles;
    }

    public UUID getSystemUserID() {
        return systemUserID;
    }

    public void setSystemUserID(UUID systemUserID) {
        this.systemUserID = systemUserID;
    }

    public String getSystemUserName() {
        return systemUserName;
    }

    public void setSystemUserName(String systemUserName) {
        this.systemUserName = systemUserName;
    }

    public String getSystemUserSurname() {
        return systemUserSurname;
    }

    public void setSystemUserSurname(String systemUserSurname) {
        this.systemUserSurname = systemUserSurname;
    }

    public String getSystemUserEmail() {
        return systemUserEmail;
    }

    public void setSystemUserEmail(String systemUserEmail) {
        this.systemUserEmail = systemUserEmail;
    }

    public String getSystemUserLogin() {
        return systemUserLogin;
    }

    public void setSystemUserLogin(String systemUserLogin) {
        this.systemUserLogin = systemUserLogin;
    }

    public String getSystemUserPassword() {
        return systemUserPassword;
    }

    public void setSystemUserPassword(String systemUserPassword) {
        this.systemUserPassword = systemUserPassword;
    }

    public Date getSystemUserAccountCreationDate() {
        return systemUserAccountCreationDate;
    }

    public void setSystemUserAccountCreationDate(Date systemUserAccountCreationDate) {
        this.systemUserAccountCreationDate = systemUserAccountCreationDate;
    }

    public Date getSystemUserPasswordRefreshDate() {
        return systemUserPasswordRefreshDate;
    }

    public void setSystemUserPasswordRefreshDate(Date systemUserPasswordRefreshDate) {
        this.systemUserPasswordRefreshDate = systemUserPasswordRefreshDate;
    }

    public Update[] getSystemUserCreatedUpdates() {
        return systemUserCreatedUpdates;
    }

    public void setSystemUserCreatedUpdates(Update[] systemUserCreatedUpdates) {
        this.systemUserCreatedUpdates = systemUserCreatedUpdates;
    }

    public Update[] getSystemUserEditedUpdates() {
        return systemUserEditedUpdates;
    }

    public void setSystemUserEditedUpdates(Update[] systemUserEditedUpdates) {
        this.systemUserEditedUpdates = systemUserEditedUpdates;
    }

    public SystemUserRole[] getSystemUserRoles() {
        return systemUserRoles;
    }

    public void setSystemUserRoles(SystemUserRole[] systemUserRoles) {
        this.systemUserRoles = systemUserRoles;
    }
}
