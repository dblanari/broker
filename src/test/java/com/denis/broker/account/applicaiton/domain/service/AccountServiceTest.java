package com.denis.broker.account.applicaiton.domain.service;

import com.denis.broker.account.applicaiton.domain.model.Account;
import com.denis.broker.account.applicaiton.port.in.CreateCommand;
import com.denis.broker.account.applicaiton.port.out.CreateAccountPort;
import com.denis.broker.account.applicaiton.port.out.LoadAccountPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private CreateAccountPort createAccountPort;

    @Mock
    private LoadAccountPort loadAccountPort;

    @Test
    void testCreate() {
        // Given
        CreateCommand createCommand = new CreateCommand("John Doe", 100L);

        // When
        accountService.create(createCommand);

        // Then
        verify(createAccountPort, times(1)).createAccount(any(Account.class));
    }

    @Test
    void testFetch() {
        // Given
        Long accountId = 1L;
        Account account = new Account("John Doe", 100L);
        when(loadAccountPort.loadAccount(accountId)).thenReturn(account);

        // When
        Account fetchedAccount = accountService.fetch(accountId);

        // Then
        verify(loadAccountPort, times(1)).loadAccount(accountId);
        assertEquals(account, fetchedAccount);
    }
}
