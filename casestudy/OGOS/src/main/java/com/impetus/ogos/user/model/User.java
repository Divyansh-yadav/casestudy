package com.impetus.ogos.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** This pojoStores the details of the user. It is use for the validation of the user. */
@Entity
@Table(name = "user")
// @NamedQuery(query = "Select u from User u where u.email = :email and u.password=:password and isactive=true", name = "validate user")
@NamedQuery(query = "Select u from User u where u.email = :email ", name = "find user by email")
public class User implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @Column(name = "user_id")
    private String userid;

    /** This is no args constructor. This constructor generates the UUID for each user. */
    public User() {
        this.userid = UUID.randomUUID().toString();
    }

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column
    private boolean isactive = true;

    @Column
    private String role = "ROLE_CUSTOMER";

    @Column(name = "customer_rating")
    private int customerRating;

    /** @return the role of the user. */
    public String getRole() {
        return role;
    }

    /** This method sets the role of the user.
     * 
     * @param role
     *            is the role of the user. */
    public void setRole(String role) {
        this.role = role;
    }

    /** This method tells whether the user is active or inactive.
     * 
     * @return the state of the user. */

    public boolean isIsactive() {
        return isactive;
    }

    /** Sets the state of the use(active or inactive).
     * 
     * @param isactive
     *            is the state of the user that a method takes. */
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Column(name = "creationtime")
    @CreationTimestamp
    private LocalDateTime creationtime;

    @Column(name = "modificationtime")
    @UpdateTimestamp
    private LocalDateTime modificationtime;

    /** @return the password of the user. */
    public String getPassword() {
        return password;
    }

    /** @param password
     *            is the password sets by the user. */
    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    /** This method returns the unique id of the user.
     * 
     * @return the unique id of the user. */
    public String getUserid() {
        return userid;
    }

    /** @return the email of the user. */
    public String getEmail() {
        return email;
    }

    /** This method sets the email associated with the user.
     * 
     * @param email
     *            is the email of the user. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the name of the user. */
    public String getUserName() {
        return userName;
    }

    /** This method sets the name of the user.
     * 
     * @param userName
     *            is the full name of the user */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** @return customerRating */
    public int getCustomerRating() {
        return customerRating;
    }

    /** This method sets the name of the customerRating.
     * 
     * @param customerRating
     *            is the full name of the customerRating */
    public void setCustomerRating(int customerRating) {
        this.customerRating = customerRating;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", email=" + email + ", userName=" + userName + ", password=" + password + ", isactive=" + isactive
                + ", role=" + role + ", customerRating=" + customerRating + ", creationtime=" + creationtime + ", modificationtime="
                + modificationtime + "]";
    }

}