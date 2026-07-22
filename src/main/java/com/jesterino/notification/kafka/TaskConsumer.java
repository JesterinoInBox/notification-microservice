package com.jesterino.notification.kafka;

import com.jesterino.notification.event.TaskCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskConsumer {

    @KafkaListener(topics = "task-events", groupId = "notification-group")
    public void listen(TaskCreatedEvent event) {

        log.info("========== NEW EVENT ==========");
        log.info("Task id: {}", event.id());
        log.info("Title: {}", event.title());
        log.info("User: {}", event.userId());
        log.info("Category: {}", event.categoryId());
        log.info("Status: {}", event.status());
    }
}