package com.zemosolearnings.kafkamongo.kafka;

import com.zemosolearnings.kafkamongo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentKafkaConsumer {

    @KafkaListener(topics = "students-database", groupId = "students")
    public void sendMessage(Student student){
        log.info("Message received "+student.toString());
    }
}
