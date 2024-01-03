package com.denis.broker.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReceiver {
    @JmsListener(destination = "trigger-queue")
    public void processMessage(String message) {
        log.info("MessageReceiver : {}", message);
    }

}
