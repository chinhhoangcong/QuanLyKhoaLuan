/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcc.services;

import com.hcc.pojo.UserRole;
import java.util.List;

/**
 *
 * @author HIEN
 */
public interface UserRoleService {
    List<UserRole> getUserRoles();
    UserRole getUserRole(Integer id);
}
