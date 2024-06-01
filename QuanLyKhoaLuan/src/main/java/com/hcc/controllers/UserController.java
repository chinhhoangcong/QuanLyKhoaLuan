/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.Student;
import com.hcc.pojo.Teacher;
import com.hcc.pojo.User;
import com.hcc.pojo.UserRole;


import com.hcc.services.StudentService;

import com.hcc.services.UserRoleService;
import com.hcc.services.UserService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HIEN
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
       
    @Autowired
    private StudentService studentService;
    

    
    
    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("listUserRole", this.userRoleService.getUserRoles());
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/user")
    public String user(Model model, @ModelAttribute("userInfo") User userInfo,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw,
            @RequestParam(value = "userRoleName", required = false, defaultValue = "") String userRoleName){
        model.addAttribute("user",userService.getUsers(kw, userRoleName));
        System.out.println(kw+ userRoleName);
        return "user";
    }
    
//    @PostMapping(value = "/user")
//    public String addUser(@ModelAttribute(value = "userInfo") @Valid User userInfo, 
//            BindingResult result){
//        if(!result.hasErrors()){
//            this.userService.addOrUpdate(userInfo);
//            return "redirect:/user";
//        }
//        return "user";
//    }
    
    @RequestMapping("/user/{userId}/password")
    public String password(Model model, 
            @PathVariable(value = "userId") String userId){
        return "password";
    }
    
    @PostMapping("/user/{userId}/password")
    public String changePassword(Model model,@PathVariable(value = "userId") String userId, 
            @RequestParam(value = "oldPassword", required = false, defaultValue = "") String oldPassword, 
            @RequestParam(value="newPassword", required = false, defaultValue = "") String newPassword){
        String msg = "";
        if(passwordEncoder.matches(oldPassword, userService.getUserById(userId).getPassword())){
            userService.changePassword(userService.getUserById(userId), newPassword);
            msg = "ĐỔI MẬT KHẨU THÀNH CÔNG";
        }
        else
            msg = "MẬT KHẨU CŨ KHÔNG KHỚP";
        System.out.println(msg);
        model.addAttribute("msg", msg);
        return "password";
    }
    
    @RequestMapping("/user/account/{userId}")
    public String account(Model model, @PathVariable(value = "userId") String userId){
        model.addAttribute("userPage", userService.getUserById(userId));
        return "account";
    }
    
    @GetMapping("/user/account/edit/{userId}")
    public String userEdit(Model model, @PathVariable(value = "userId") String id, @ModelAttribute(value = "userInfo") User u){
        User user = this.userService.getUserById(id);
        model.addAttribute("userEdit", user );
        return "useritem";
    }
    
    
}
