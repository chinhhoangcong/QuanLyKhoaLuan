/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repositories;

import com.hcc.pojo.Thesis;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ThesisRepository {
    List<Thesis> getThesises();
    void addOrUpdate(Thesis p);
}
