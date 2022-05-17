package com.thotholani.sms.service;

import com.thotholani.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentById(long id);
}
