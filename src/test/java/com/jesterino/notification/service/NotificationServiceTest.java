//package com.jesterino.notification.service;
//
//import com.jesterino.notification.event.TaskCreatedEvent;
//import com.jesterino.notification.strategy.NotificationType;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import java.time.Duration;
//
//import static org.awaitility.Awaitility.await;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest
//@EmbeddedKafka(
//        partitions = 1,
//        topics = "task-events"
//)
//class NotificationServiceTest {
//
//    @Autowired
//    KafkaTemplate<String, TaskCreatedEvent> kafkaTemplate;
//
//    @MockitoBean
//    NotificationService notificationService;
//
//    @Test
//    void shouldConsumeKafkaMessage() {
//
//        TaskCreatedEvent event =
//                new TaskCreatedEvent(
//                        1L,
//                        "Task",
//                        "John",
//                        "EMAIL",
//                        "TODO",
//                        NotificationType.EMAIL
//                );
//
//        kafkaTemplate.send("task-events", event);
//
//        await()
//                .atMost(Duration.ofSeconds(5))
//                .untilAsserted(() ->
//                        verify(notificationService)
//                                .send(
//                                        NotificationType.EMAIL,
//                                        "Task created"
//                                ));
//    }
//}
