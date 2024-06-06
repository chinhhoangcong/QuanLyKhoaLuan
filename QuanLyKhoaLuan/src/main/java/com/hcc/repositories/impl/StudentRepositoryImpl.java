/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories.impl;


import com.hcc.pojo.Student;
import com.hcc.pojo.Thesis;
import com.hcc.pojo.User;
import com.hcc.repositories.StudentRepository;
import com.hcc.services.ThesisService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HIEN
 */
@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    
    
    
    @Override
    public List<Student> getStudents(Map<String, String> params) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try{
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root root = query.from(Student.class);
                            
            List<Predicate> predicates = new ArrayList<>();
            if(!params.isEmpty()){
                System.out.println("KHÔNG RỖNG");
                if(!params.get("kw").isEmpty() && params.get("kw")!=null){
                    System.out.println(params.get("kw"));
                    Predicate p1 = builder.like(root.get("firstName").as(String.class),params.get("kw"));
                    Predicate p2 = builder.like(root.get("lastName").as(String.class),params.get("kw"));
                    predicates.add(builder.or(p1,p2));
                }
                
                System.out.println(predicates.size());
                query.where(builder.and(predicates.toArray(new Predicate[]{})));
            }
            
            query = query.multiselect(root);
            Query q = s.createQuery(query);
            System.out.println(q.getResultList().size());
            return q.getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Student getStudentById(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        
        return s.get(Student.class, id);
    }

    @Override
    public void addOrUpdateStudent(Student student) {
        Session s = sessionFactory.getObject().getCurrentSession();

            s.save(student);
   }

    @Override
    public void addThesis(Student stdnt, Thesis thesis) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try{
            stdnt.setThesisId(thesis);
            s.update(stdnt);
        }
        catch(Exception ex){
            System.out.println("LỖI RỒIIIII");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }

    }

   
}
