package com.denis.broker.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {
        send("Fixed delay task - " + System.currentTimeMillis());
    }

    public void send(String message) {
        jmsTemplate.convertAndSend(message);
        log.info("MessageSender sent: {}", message);
    }
}
