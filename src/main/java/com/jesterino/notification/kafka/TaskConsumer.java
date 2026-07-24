package com.jesterino.notification.kafka;

import com.jesterino.notification.event.TaskCreatedEvent;
import com.jesterino.notification.service.NotificationService;
import com.jesterino.notification.strategy.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "task-events")
    public void listen(TaskCreatedEvent event) {

        log.info("========== NEW EVENT ==========");
        log.info("Task id: {}", event.id());
        log.info("Title: {}", event.title());
        log.info("User: {}", event.user());
        log.info("Category: {}", event.category());
        log.info("Status: {}", event.status());

        notificationService.send(
                event.category(),
                "New task created"
        );
    }
}