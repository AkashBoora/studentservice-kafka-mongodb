package com.zemosolearnings.kafkamongo.controller;

import com.zemosolearnings.kafkamongo.entity.Student;
import com.zemosolearnings.kafkamongo.kafka.StudentKafkaProducer;
import com.zemosolearnings.kafkamongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
    @Autowired
    StudentKafkaProducer studentKafkaProducer;
    @Autowired
    StudentService studentService;

    public StudentController(StudentKafkaProducer studentKafkaProducer) {
        this.studentKafkaProducer = studentKafkaProducer;
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        log.info("==================> StudentController: createStudent");
        Student student1 = studentService.saveStudent(student);
        studentKafkaProducer.sendMessage(student1);
        return ResponseEntity.ok(student1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        log.info("==================> StudentController: getStudentById");
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(studentKafkaProducer.sendMessage(student));
    }

}
