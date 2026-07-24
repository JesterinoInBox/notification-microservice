package com.jesterino.notification.service;

import com.jesterino.notification.strategy.NotificationStrategyFactory;
import com.jesterino.notification.strategy.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationStrategyFactory factory;


    public void send(NotificationType type, String message) {

        factory.get(type)
                .sendNotification(message);

    }
}