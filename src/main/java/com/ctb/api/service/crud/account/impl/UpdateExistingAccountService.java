package com.ctb.api.service.crud.account.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.service.crud.account.IUpdateExistingAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class UpdateExistingAccountService implements IUpdateExistingAccountService {

	private final IAccountRepository accountRepository;

	public boolean update(String email, String newEmail, String newPassword) {

		AccountDAO account = accountRepository.findByEmail(email);
		account.setEmail(newEmail);
		account.setPassword(newPassword);

		return createNewTransaction(account, email);
	}

	@Transactional
	boolean createNewTransaction(AccountDAO account, String email) {
		if (saveAccountToDatabase(account, email)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	private boolean saveAccountToDatabase(AccountDAO account, String email) {
		accountRepository.save(account);

		return accountUpdatedCorrectly(account, email);
	}

	private boolean accountUpdatedCorrectly(AccountDAO account, String email) {
		return !accountRepository.findByEmail(email).getEmail().equals(email);
	}
}
