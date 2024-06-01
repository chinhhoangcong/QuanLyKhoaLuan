/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hcc.repositories;


import com.hcc.pojo.Student;
import com.hcc.pojo.Thesis;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HIEN
 */
public interface StudentRepository {
    List<Student> getStudents(Map<String,String> params);
    Student getStudentById(String id);
    void addOrUpdateStudent(Student s);
    void addThesis(Student s, Thesis t);

}
