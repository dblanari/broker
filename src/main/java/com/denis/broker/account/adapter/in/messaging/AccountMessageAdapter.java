package com.denis.broker.account.adapter.in.messaging;

import com.denis.broker.account.applicaiton.port.in.LoggingUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
class AccountMessageAdapter {

    private LoggingUseCase loggingUseCase;

    @JmsListener(destination = "trigger-queue")
    public void processMessage(String message) {
        log.info("MessageReceiver : {}", message);
        loggingUseCase.alertLogAccounts(message);
    }

}
