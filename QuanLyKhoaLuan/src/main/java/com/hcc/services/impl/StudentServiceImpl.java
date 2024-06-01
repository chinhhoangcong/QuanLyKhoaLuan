/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.services.impl;


import com.hcc.pojo.Student;
import com.hcc.pojo.Thesis;
import com.hcc.repositories.StudentRepository;
import com.hcc.services.StudentService;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEN
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(Map<String, String> kw) {
        return this.studentRepository.getStudents(kw);
    }

    @Override
    public Student getStudentById(String id) {
        return this.studentRepository.getStudentById(id);
    }

    @Override
    public void addOrUpdateStudent(Student s) {
        this.studentRepository.addOrUpdateStudent(s);
    }

    @Override
    public void addThesis(Student stdnt, Thesis thesis) {
         this.studentRepository.addThesis(stdnt, thesis);
    }


}
