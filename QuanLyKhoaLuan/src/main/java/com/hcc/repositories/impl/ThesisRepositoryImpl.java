/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories.impl;

import com.hcc.pojo.Thesis;
import com.hcc.repositories.ThesisRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ThesisRepositoryImpl implements ThesisRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Thesis> getThesises(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Thesis> q = b.createQuery(Thesis.class);
        Root r = q.from(Thesis.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
        }

//        String fromPrice = params.get("fromPrice");
//        if (fromPrice != null && !fromPrice.isEmpty()) {
//            predicates.add(b.greaterThanOrEqualTo(r.get("price"), Double.parseDouble(fromPrice)));
//        }
//
//        String toPrice = params.get("toPrice");
//        if (toPrice != null && !toPrice.isEmpty()) {
//            predicates.add(b.lessThanOrEqualTo(r.get("price"), Double.parseDouble(toPrice)));
//        }
//        String cateId = params.get("cateId");
//        if (cateId != null && !cateId.isEmpty()) {
//            predicates.add(b.equal(r.get("categoryId"), Integer.parseInt(cateId)));
//        }
        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

        String p = params.get("page");
        if (p != null && !p.isEmpty()) {
            int pageSize = Integer.parseInt(env.getProperty("thesis.pageSize").toString());
            int start = (Integer.parseInt(p) - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);
        }

        List<Thesis> thesises = query.getResultList();

        return thesises;

    }

    @Override
    public void addOrUpdate(Thesis p) {
        Session s = factory.getObject().getCurrentSession();
        if (p.getId() > 0) {
            s.update(p);
        } else {
            s.save(p);
        }
    }

    @Override
    public Thesis getThesisbyId(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Thesis.class, id);
    }

    @Override
    public void deleteThesis(int id) {
        Session s = factory.getObject().getCurrentSession();
        Thesis p = this.getThesisbyId(id);
        s.delete(p);
    }
}
