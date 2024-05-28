/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.Thesis;
import com.hcc.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ACER
 */
@Controller
public class ThesisController {

    @Autowired
    private ThesisService thesisSer;

    @GetMapping("/thesises")
    public String createView(Model model) {
        model.addAttribute("thesis", new Thesis());
        
        return "addThesis";
    }

    @PostMapping("/thesises")
    public String createThesis(@ModelAttribute(value = "thesis") Thesis p) {
        try {
            this.thesisSer.addOrUpdate(p);
            return "redirect:/";
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return "index";
    }
    
    @GetMapping("/thesises/{thesisId}")
    public String updateView(Model model,@PathVariable(value = "thesisId") int id) {
        model.addAttribute("thesis", this.thesisSer.getThesisbyId(id));
        
        return "addThesis";
    }
}
