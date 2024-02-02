package com.denis.broker.account.applicaiton.domain.service;

import com.denis.broker.account.applicaiton.port.in.NotificationUseCase;
import com.denis.broker.account.applicaiton.port.out.LoadAccountPort;
import com.denis.broker.account.applicaiton.port.out.MessageAccountPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationService implements NotificationUseCase {

    private final LoadAccountPort loadAccountPort;
    private final MessageAccountPort messageAccountPort;

    @Override
    public void notifyAllAccounts() {
        loadAccountPort.loadAccounts().forEach(messageAccountPort::sendAccount);
    }
}
