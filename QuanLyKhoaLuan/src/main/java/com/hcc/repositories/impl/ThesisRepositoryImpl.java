/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories.impl;

import com.hcc.pojo.Thesis;
import com.hcc.repositories.ThesisRepository;
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
public class ThesisRepositoryImpl implements ThesisRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Thesis> getThesises() {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Thesis.findAll");
        return q.getResultList();

    }

    @Override
    public void addOrUpdate(Thesis p) {
        Session s = factory.getObject().getCurrentSession();

        s.save(p);
    }
}

