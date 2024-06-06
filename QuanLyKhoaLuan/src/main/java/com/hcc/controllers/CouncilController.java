/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.services.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class CouncilController {

    @Autowired
    private CouncilService counService;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("council", this.counService.getCouncils());
    }

    @GetMapping("/council")
    public String viewCouncil(Model model) {        
        return "council";
    }
}
