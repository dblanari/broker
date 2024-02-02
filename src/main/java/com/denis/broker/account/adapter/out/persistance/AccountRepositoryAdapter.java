package com.denis.broker.account.adapter.out.persistance;

import com.denis.broker.account.applicaiton.domain.model.Account;
import com.denis.broker.account.applicaiton.port.out.CreateAccountPort;
import com.denis.broker.account.applicaiton.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class AccountRepositoryAdapter implements CreateAccountPort, LoadAccountPort {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        accountRepository.save(accountMapper.toEntity(account));
    }

    @Override
    public Account loadAccount(Long accountId) {
        return accountMapper.toModel(accountRepository.getReferenceById(accountId));
    }

    @Override
    public List<Account> loadAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toModel)
                .collect(Collectors.toList());
    }
}
