package com.ctb.api.components.account.services.crud.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.crud.IDeleteExistingAccountService;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class DeleteExistingAccountService implements IDeleteExistingAccountService {

	private final IAccountRepository accountRepository;

	public boolean delete(AccountDAO account) {

		if (account == null)
			return false;

		return createNewTransaction(account);
	}

	@Transactional
	boolean createNewTransaction(AccountDAO account) {
		if (deleteAccount(account)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Logger.log("ERROR", "Transaction Rollback. Error whilst deleting account");
			return false;
		}
	}

	private boolean deleteAccount(AccountDAO account) {

		account.getRecipes().forEach(r -> r.setFeedbacks(null));
		account.getRecipes().forEach(r -> r.getIngredients().forEach(i -> i = null));
		account.setRecipes(null);
		account.setFeedbacks(null);

		accountRepository.delete(account);

		return accountDeletedCorrectly(account);
	}

	private boolean accountDeletedCorrectly(AccountDAO account) {
		return accountRepository.findByEmail(account.getEmail()) == null;
	}
}
