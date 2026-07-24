package com.jesterino.notification.event;

public record TaskCreatedEvent(
        Long id,
        String title,
        String user,
        String category,
        String status
) {}