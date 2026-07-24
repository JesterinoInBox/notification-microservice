package com.jesterino.notification.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        log.info("Sending telegram: {}", message);
    }

    @Override
    public NotificationType getType() {
        return NotificationType.TELEGRAM;
    }
}
