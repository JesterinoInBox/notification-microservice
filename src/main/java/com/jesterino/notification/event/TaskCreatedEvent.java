package com.jesterino.notification.event;

import com.jesterino.notification.strategy.NotificationType;

public record TaskCreatedEvent(
        Long id,
        String title,
        String user,
        String category,
        String status,
        NotificationType notificationType
) {}