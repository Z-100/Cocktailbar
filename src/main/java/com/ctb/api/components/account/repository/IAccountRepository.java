package com.ctb.api.components.account.repository;

import com.ctb.api.components.account.dao.AccountDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends CrudRepository<AccountDAO, Long> {

	AccountDAO findByEmail(String email);

	AccountDAO findByEmailAndPassword(String email, String password);
}
