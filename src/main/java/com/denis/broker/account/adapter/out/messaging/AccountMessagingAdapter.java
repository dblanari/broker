package com.denis.broker.account.adapter.out.messaging;

import com.denis.broker.account.applicaiton.domain.model.Account;
import com.denis.broker.account.applicaiton.port.out.MessageAccountPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountMessagingAdapter implements MessageAccountPort {

    private final JmsTemplate jmsTemplate;

//    @Scheduled(fixedDelay = 5000)
//    public void scheduleFixedDelayTask() {
//        send("Fixed delay task - " + System.currentTimeMillis());
//    }

    @Override
    public void sendAccount(Account account) {
        jmsTemplate.convertAndSend(account.getName());
        log.info("MessageSender sent: {}", account);
    }
}
