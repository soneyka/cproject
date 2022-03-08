package com.example.cproject.service;

import com.example.cproject.entity.DAOUserMkrtchanLS;
import com.example.cproject.repository.UserDaoMkrtchanLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceMkrtchanLS implements UserDetailsService {

    @Autowired
    private UserDaoMkrtchanLS repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUserMkrtchanLS user = repository.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден с именем + " + username);
        }
        return user;
    }
}
