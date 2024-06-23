/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.controllers;

import com.hcc.pojo.Thesis;
import com.hcc.services.ThesisService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiThesisController {

    @Autowired
    private ThesisService thesisService;

    @DeleteMapping("/thesises/{thesisId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "thesisId") int id){
        this.thesisService.deleteThesis(id);
    }
    
    @GetMapping("/thesises/")
    @CrossOrigin
    public ResponseEntity<List<Thesis>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.thesisService.getThesises(params), HttpStatus.OK);
    }
    
    @GetMapping(path = "/thesises/{thesisId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Thesis> retrieve(@PathVariable(value = "thesisId") int id) {
        return new ResponseEntity<>(this.thesisService.getThesisbyId(id), HttpStatus.OK);
    }
}
