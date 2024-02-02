package com.denis.broker.account.adapter.out.file;

import com.denis.broker.account.applicaiton.port.out.LogAccountPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class LogAccountAdapter implements LogAccountPort {

    @Override
    public void logAccount(String account) {
        log.info("FILE log - {}", account);
    }
}
