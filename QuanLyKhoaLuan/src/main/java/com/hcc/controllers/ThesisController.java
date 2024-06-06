/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.Student;
import com.hcc.pojo.Thesis;
import com.hcc.services.StudentService;
import com.hcc.services.ThesisService;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class ThesisController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ThesisService thesisSer;

    public List<Student> thesisStudents = new ArrayList<>();

    @ModelAttribute
    public void commonAttr(Model model,@RequestParam Map<String, String> params) {
       model.addAttribute("listStudent", this.studentService.getStudents(new HashMap<String,String>()));
    }

    @RequestMapping("/thesises")
    public String createView(Model model, @RequestParam(value = "studentId", required = false, defaultValue = "0") int studentId,
            @RequestParam(value="removeId", required = false, defaultValue = "") String removeId) {
        model.addAttribute("thesis", new Thesis());
        if (studentService.getStudentById(studentId) != null) {
            thesisStudents.add(studentService.getStudentById(studentId));
            System.out.println(thesisStudents.size());
        }
        if(!removeId.isEmpty() && removeId!="" && !thesisStudents.isEmpty()) {
            for (int i =0; i<thesisStudents.size();i++){
                if(thesisStudents.get(i).getFirstName().equals(removeId)){
                    thesisStudents.remove(i);
                }
            }
            System.out.println(thesisStudents.size());
        }
        
        model.addAttribute("students", thesisStudents);

        return "addThesis";
    }

    @PostMapping("/thesises")
    public String createThesis(@ModelAttribute(value = "thesis") Thesis p) {
        try {
            this.thesisSer.addOrUpdate(p);
            if (thesisStudents.size() > 0) {
                for (Student thesisStudent : thesisStudents) {
                    studentService.addThesis(thesisStudent, p);
                }
            }
            return "redirect:/";
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return "index";
    }

    @GetMapping("/thesises/{thesisId}")
    public String updateView(Model model, @PathVariable(value = "thesisId") int id) {
        model.addAttribute("thesisPage", this.thesisSer.getThesisbyId(id));
        
        return "thesisDetail";
    }
}
