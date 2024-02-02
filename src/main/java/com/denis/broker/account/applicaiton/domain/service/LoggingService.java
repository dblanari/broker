package com.denis.broker.account.applicaiton.domain.service;

import com.denis.broker.account.applicaiton.port.in.LoggingUseCase;
import com.denis.broker.account.applicaiton.port.in.NotificationUseCase;
import com.denis.broker.account.applicaiton.port.out.LoadAccountPort;
import com.denis.broker.account.applicaiton.port.out.LogAccountPort;
import com.denis.broker.account.applicaiton.port.out.MessageAccountPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoggingService implements LoggingUseCase {

    private final LogAccountPort logAccountPort;

    @Override
    public void alertLogAccounts(String account) {
        logAccountPort.logAccount(account);
    }
}
