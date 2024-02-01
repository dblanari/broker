package com.denis.broker.account.applicaiton.port.in;

import com.denis.broker.account.applicaiton.domain.model.Account;

public interface FetchUseCase {

    Account fetch(Long id);

}
