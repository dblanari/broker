package com.denis.broker.account.applicaiton.domain.service;

import com.denis.broker.account.applicaiton.domain.model.Account;
import com.denis.broker.account.applicaiton.port.in.CreateCommand;
import com.denis.broker.account.applicaiton.port.in.CreateUseCase;
import com.denis.broker.account.applicaiton.port.in.FetchUseCase;
import com.denis.broker.account.applicaiton.port.out.CreateAccountPort;
import com.denis.broker.account.applicaiton.port.out.LoadAccountPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountService implements CreateUseCase, FetchUseCase {

    private final CreateAccountPort createAccountPort;
    private final LoadAccountPort loadAccountPort;

    @Override
    public void create(CreateCommand createCommand) {
        final Account account = new Account(createCommand.getName(), createCommand.getBalance());
        createAccountPort.createAccount(account);
    }

    @Override
    public Account fetch(Long id) {
        return loadAccountPort.loadAccount(id);
    }
}
