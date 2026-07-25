package com.jesterino.notification.strategy;

import org.springframework.stereotype.Component;

@Component
public interface NotificationStrategy {
    void sendNotification(String message);

    NotificationType getType();
}
