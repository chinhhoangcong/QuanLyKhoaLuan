/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.Student;
import com.hcc.pojo.Thesis;

import com.hcc.services.StudentService;

import com.hcc.services.ThesisService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HIEN
 */
@Controller
public class StudentController {

    @Autowired
    private ThesisService thesisService;

    @Autowired
    private StudentService studentService;

//    @GetMapping("/student")
//    public String student(Model model,
//            @RequestParam Map<String,String> params){
//        model.addAttribute("studentInfo", new Student());
//        model.addAttribute("listStudent", studentService.getStudents(params));
//        
//        
//        return "student";
//    }
//    
//    @PostMapping(value = "/student")
//    public String addStudent(@ModelAttribute(value = "studentInfo")Student studentInfo){
//        this.studentService.addOrUpdateStudent(studentInfo);
//            
//        
//        return "index";
//    }
    @GetMapping("/student")
    public String student(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("studentInfo", new Student());
        model.addAttribute("listStudent", studentService.getStudents(params));
        return "student";
    }

    @PostMapping("/student")
    public String addStudent(@ModelAttribute(value = "studentInfo") Student studentInfo) {
        try {
            this.studentService.addOrUpdateStudent(studentInfo);
            return "redirect:/";
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return "index";
    }
}
