package com.denis.broker.account.applicaiton.port.out;


import com.denis.broker.account.applicaiton.domain.model.Account;

import java.util.List;

public interface LoadAccountPort {

    Account loadAccount(Long accountId);

    List<Account> loadAccounts();

}
