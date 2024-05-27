/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.services.impl;

import com.hcc.pojo.Thesis;
import com.hcc.repositories.ThesisRepository;
import com.hcc.services.ThesisService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisRepository theSisRepo;

    @Override
    public List<Thesis> getThesises() {
        return this.theSisRepo.getThesises();
    }

    @Override
    public void addOrUpdate(Thesis p) {
        this.theSisRepo.addOrUpdate(p);
    }

}
