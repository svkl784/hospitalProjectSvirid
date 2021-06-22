package com.project.hospital.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user")
public class User
        implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id_user;
    @Column(name = "user_name")
    @Size(min=2, message = "At least 5 characters")
    private String userName;
    @Column(name = "password")
    @Size(min=2, message = "At least 5 characters")
    private String password;
    @Transient
    private String passwordConfirm;

    //        @ElementCollection (targetClass = Role.class, fetch = FetchType.EAGER)
//        @CollectionTable (name = "user_role", joinColumns = @JoinColumn(name = "id_user"))
//        @Enumerated (EnumType.STRING)
//        private Set<Role> role;
    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",joinColumns = @JoinColumn(name = "users_id_user"))
    private Set <Role> roles;

    public User() {
    }

    public User(Long id_user, String userName, String password) {
        this.id_user = id_user;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + roles +
                '}';
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }


    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public String getUserName() {
        return null;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
