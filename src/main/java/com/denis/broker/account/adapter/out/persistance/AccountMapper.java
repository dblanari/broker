package com.denis.broker.account.adapter.out.persistance;

import com.denis.broker.account.applicaiton.domain.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountEntity toEntity(Account transaction);

    Account toModel(AccountEntity accountEntity);

}
