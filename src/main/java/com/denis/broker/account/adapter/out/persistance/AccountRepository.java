package com.denis.broker.account.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
