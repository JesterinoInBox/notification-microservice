package com.jesterino.notification.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationStrategyFactory {


    private final List<NotificationStrategy> strategies;


    public NotificationStrategy get(NotificationType type){

        return strategies.stream()
                .filter(s -> s.getType() == type)
                .findFirst()
                .orElseThrow();

    }
}