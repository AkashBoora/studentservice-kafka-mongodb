package com.zemosolearnings.kafkamongo.service;

import com.zemosolearnings.kafkamongo.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student findStudentById(String id);
}
