/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.services.CouncilService;
import com.hcc.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ThesisService sisService;
    
    @Autowired
    private CouncilService counService;
    
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("council", this.counService.getCouncils());
    }
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("thesis",this.sisService.getThesises());
        return "index";
    }
}
