package com.pmikeladze.siteScript.services;

import com.pmikeladze.siteScript.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*Стандартный сервис для работы с Секьюрити и ролями*/
@Service
public class UserServices implements UserDetailsService {

    private final UserRepo userRepo;
    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

}
