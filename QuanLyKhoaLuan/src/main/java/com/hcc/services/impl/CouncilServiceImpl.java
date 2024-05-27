/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.services.impl;

import com.hcc.pojo.Council;
import com.hcc.repositories.CouncilRepository;
import com.hcc.services.CouncilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CouncilServiceImpl implements CouncilService{
    @Autowired
    private CouncilRepository councilRepo;
    
    
    @Override
    public List<Council> getCouncils() {
        return this.councilRepo.getCouncils();
    }
    
}
