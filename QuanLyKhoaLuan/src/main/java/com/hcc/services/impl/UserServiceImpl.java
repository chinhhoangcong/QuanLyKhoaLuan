/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.services.impl;


import com.hcc.pojo.User;
import com.hcc.repositories.UserRepository;
import com.hcc.services.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author ACER
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
      
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole().getName()));
        
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

}
