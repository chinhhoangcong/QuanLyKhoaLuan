/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.User;
import com.hcc.services.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private BCryptPasswordEncoder passswordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/users/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        User u = new User();
        u.setId(params.get("id"));
        u.setUsername(params.get("username"));
        String password = params.get("password");
        u.setPassword(this.passswordEncoder.encode(password));
        u.setUserRole("ROLE_USER");
        u.setActive(true);
        if (file.length > 0)
            u.setFile(file[0]);
        

        this.userService.addUser(u);
    }

//    @PostMapping("/login/")
//    @CrossOrigin
//    public ResponseEntity<String> login(@RequestBody User user) {
//        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
//            String token = this.jwtService.generateTokenLogin(user.getUsername());
//            
//            return new ResponseEntity<>(token, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
//    }
//    
//    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    public ResponseEntity<User> getCurrentUser(Principal p) {
//        User u = this.userService.getUserByUsername(p.getName());
//        return new ResponseEntity<>(u, HttpStatus.OK);
//    }
}
