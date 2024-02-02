package com.denis.broker.account.adapter.in.web;

import com.denis.broker.account.applicaiton.domain.model.Account;
import com.denis.broker.account.applicaiton.port.in.CreateCommand;
import com.denis.broker.account.applicaiton.port.in.CreateUseCase;
import com.denis.broker.account.applicaiton.port.in.FetchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
class AccountController {

    private final CreateUseCase createUseCase;
    private final FetchUseCase fetchUseCase;

    @PostMapping(path = "/accounts/create/{name}/{balance}")
    void create(@PathVariable("name") String name, @PathVariable("balance") Long balance) {

        final CreateCommand command = new CreateCommand(name, balance);
        createUseCase.create(command);
    }

    @GetMapping(path = "/accounts/{id}")
    Account fetch(@PathVariable("id") Long id) {
        return fetchUseCase.fetch(id);
    }

}
