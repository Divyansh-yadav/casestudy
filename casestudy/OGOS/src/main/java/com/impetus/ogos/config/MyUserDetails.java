package com.impetus.ogos.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 *
 */
public class MyUserDetails implements UserDetails {

    /** A unique id. */
    private static final long serialVersionUID = -8916930188823281234L;
    private String userId;
    private String email;
    private String name;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    /** @param userId
     *            is [primary key of user.
     * @param email
     *            is email id of user.
     * @param password
     *            is user login password.
     * @param authorities
     *            is user authorize for login or not.
     * @param name
     *            is user login name.
     * @param isActive
     *            user is active or not. */
    public MyUserDetails(String userId, String email, String name, String password, Collection<? extends GrantedAuthority> authorities,
            boolean isActive) {
        this(userId, email, name, password, true, true, true, isActive, authorities);
    }

    /** @param userId
     *            is [primary key of user.
     * @param email
     *            is email id of user.
     * @param password
     *            is user login password.
     * @param accountNonExpired
     * @param accountNonLocked
     * @param credentialsNonExpired
     * @param enabled
     *            is user has access to login.
     * @param authorities
     *            is user authorize for login or not.
     * @param name
     *            is user login name. */
    public MyUserDetails(String userId, String email, String name, String password, boolean accountNonExpired, boolean accountNonLocked,
            boolean credentialsNonExpired, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
        this.name = name;
    }

    /** @return userId */
    public String getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /** @return name */
    public String getName() {
        return name;
    }

    /** @param name
     *            is user name */
    public void setName(String name) {
        this.name = name;
    }

}
