package com.denis.broker.account.adapter.in.scheduler;

import com.denis.broker.account.applicaiton.port.in.NotificationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AccountSchedulerAdapter {

    private NotificationUseCase notificationUseCase;

    @Scheduled(fixedDelay = 5000)
    public void scheduleNotifyTask() {
        notificationUseCase.notifyAllAccounts();
    }
}
