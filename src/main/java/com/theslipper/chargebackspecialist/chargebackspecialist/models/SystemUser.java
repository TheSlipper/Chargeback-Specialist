package com.theslipper.chargebackspecialist.chargebackspecialist.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "system_user_name", nullable = false)
    private String systemUserName;

    @Column(name = "system_user_surname", nullable = false)
    private String systemUserSurname;

    @Column(name = "system_user_email", nullable = false)
    private String systemUserEmail;

    @Column(name = "system_user_login", nullable = false)
    private String systemUserLogin;

    @Column(name = "system_user_password", nullable = false)
    private String systemUserPassword;

    @Column(name = "system_user_account_creation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date systemUserAccountCreationDate;

    @Column(name = "system_user_password_refresh_date")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private Date systemUserPasswordRefreshDate;

    @OrderColumn(name = "system_user_roles")
    @ManyToOne
    private SystemUserRole systemUserRole;

    public SystemUser() {
    }

    public SystemUser(@JsonProperty("systemUserID") UUID systemUserID,
                      @JsonProperty("systemUserName") String username,
                      @JsonProperty("systemUserSurname") String surname,
                      @JsonProperty("systemUserEmail") String email,
                      @JsonProperty("systemUserLogin") String login,
                      @JsonProperty("systemUserPassword") String password,
                      @JsonProperty("systemUserAccountCreationDate") Date systemUserAccountCreationDate,
                      @JsonProperty("systemUserPasswordRefreshDate") Date systemUserPasswordRefreshDate,
                      @JsonProperty("systemUserRoles") SystemUserRole systemUserRole) {
        this.systemUserID = systemUserID;
        this.systemUserName = username;
        this.systemUserSurname = surname;
        this.systemUserEmail = email;
        this.systemUserLogin = login;
        this.systemUserPassword = password;
        this.systemUserAccountCreationDate = systemUserAccountCreationDate;
        this.systemUserPasswordRefreshDate = systemUserPasswordRefreshDate;
        this.systemUserRole = systemUserRole;
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

    public SystemUserRole getSystemUserRole() {
        return systemUserRole;
    }

    public void setSystemUserRole(SystemUserRole systemUserRoles) {
        this.systemUserRole = systemUserRoles;
    }
}
