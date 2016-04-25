package com.sample.hateoas.core.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by andresmerida on 4/4/2016.
 */

@Entity
@Table(name = "User")
public class User extends AbstractAuditingEntity implements Serializable{

    private static final long serialVersionUID = 141481953116476081L;

    @Id
    @GeneratedValue
    @Column(name = "userid")
    private Long userId;

    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "identitynumber")
    private String identityNumber;

    @Column(name = "birthdate")
    private Date birthDate;

    private String phone;

    private String address;

    private String email;   // email is equivalent to loguin in this case

    private String password;

    private Boolean deleted;

    @Column(name = "enterpriseid")
    private Integer enterpriseId;

    @Column(name = "branchofficeid")
    private Integer branchOfficeId;

    public User() {
    }

    // this method is only for spring security, session and authentification
    public User(User user){
        this.userId     = user.userId;
        this.name       = user.name;
        this.email      = user.email;
        this.password   = user.password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
