package com.jesterino.notification.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        log.info("Sending email: {}", message);
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
