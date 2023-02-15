package com.zemosolearnings.kafkamongo.repository;

import com.zemosolearnings.kafkamongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
