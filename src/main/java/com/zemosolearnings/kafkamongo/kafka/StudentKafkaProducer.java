package com.zemosolearnings.kafkamongo.kafka;

import com.zemosolearnings.kafkamongo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentKafkaProducer {
    private KafkaTemplate<String,User> kafkaTemplate;

    public StudentKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Student sendMessage(Student student){
        log.info("Message sent "+student.toString());
        Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC,"students-database").build();
        kafkaTemplate.send(message);
        return student;
    }
}
