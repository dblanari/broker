package com.denis.broker.account.applicaiton.port.out;

import com.denis.broker.account.applicaiton.domain.model.Account;

public interface MessageAccountPort {
    void sendAccount(Account account);
}
