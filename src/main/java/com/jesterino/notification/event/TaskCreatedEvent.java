package com.jesterino.notification.event;

public record TaskCreatedEvent(
        Long id,
        String title,
        Long userId,
        Long categoryId,
        String status
) {}