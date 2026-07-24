package com.jesterino.notification.strategy;

public interface NotificationStrategy {
    void sendNotification(String message);

    NotificationType getType();
}
