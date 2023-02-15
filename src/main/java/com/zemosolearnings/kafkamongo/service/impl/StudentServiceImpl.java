package com.zemosolearnings.kafkamongo.service.impl;

import com.zemosolearnings.kafkamongo.entity.Student;
import com.zemosolearnings.kafkamongo.kafka.StudentKafkaProducer;
import com.zemosolearnings.kafkamongo.repository.StudentRepository;
import com.zemosolearnings.kafkamongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentKafkaProducer studentKafkaProducer;


    @Override
    public Student findStudentById(String id) {
        log.info("==================> StudentServiceImpl: findStudentById");
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        log.info("==================> StudentServiceImpl: saveStudent");
        return studentRepository.save(student);
    }
}
