package com.jesterino.notification.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        log.info("Send sms: {}", message);
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
