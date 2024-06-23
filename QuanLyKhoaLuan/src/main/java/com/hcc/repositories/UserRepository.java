/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories;

import com.hcc.pojo.User;

/**
 *
 * @author ACER
 */
public interface UserRepository {
    User getUserByUsername(String username);
    void addUser(User user);
}
