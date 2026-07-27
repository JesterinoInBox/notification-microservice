package com.jesterino.notification.service;

import com.jesterino.notification.event.TaskCreatedEvent;
import com.jesterino.notification.strategy.NotificationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}"
})
@EmbeddedKafka(partitions = 1, topics = "task-events")
class NotificationServiceTest {

    private static final String TOPIC = "task-events";

    @Autowired
    private KafkaTemplate<String, TaskCreatedEvent> kafkaTemplate;

    @MockitoBean
    private NotificationService notificationService;

    @Test
    void shouldInvokeNotificationServiceWhenTaskCreatedEventReceived() throws Exception {

        TaskCreatedEvent event = new TaskCreatedEvent(
                1L,
                "Task",
                "John",
                "EMAIL",
                "TODO",
                NotificationType.EMAIL
        );

        kafkaTemplate.send(TOPIC, event).get();

        await()
                .atMost(Duration.ofSeconds(5))
                .untilAsserted(() ->
                        verify(notificationService)
                                .send(NotificationType.EMAIL, "Task created"));
    }
}
