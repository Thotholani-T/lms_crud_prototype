package com.thotholani.sms.repository;

import com.thotholani.sms.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
