package com.pmikeladze.siteScript.entity;

import org.springframework.security.core.GrantedAuthority;


/*имлементируемся от общзей концепции секьюрити*/
public enum Role implements GrantedAuthority {

    USER,ADMIN;

    @Override
    public String getAuthority() {
        /*Строковое представление значения роли*/
        return name();
    }
}
