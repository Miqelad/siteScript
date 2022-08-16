package com.pmikeladze.siteScript.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@Table(name = "usr")
/*Имплементируемся от общей концепции Спринг Секьюрити*/
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 5,max = 20,message = "Login length between  5 to 20")
    @NotEmpty(message = "Login not be empty")
    private String username;
    @Size(min = 5,max = 25,message = "Password length between 5 to 25")
    @NotEmpty(message = "Password not be empty")
    private String password;
    private boolean active;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)

    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "user_id"))
    /*Указываем, что это enum и хранить мы его хотим в виде строки*/
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Choose Role")
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
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
        return isActive();
    }

    @Builder
    public User(String username, String password, boolean active, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }
}
