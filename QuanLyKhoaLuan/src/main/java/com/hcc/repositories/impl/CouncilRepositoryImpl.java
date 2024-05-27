/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories.impl;

import com.hcc.pojo.Council;
import com.hcc.repositories.CouncilRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class CouncilRepositoryImpl implements CouncilRepository{
     @Autowired
     private LocalSessionFactoryBean factory;
     
    @Override
    public List<Council> getCouncils() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q =s.createNamedQuery("Council.findAll");
        return q.getResultList();
        
    }
    
}
