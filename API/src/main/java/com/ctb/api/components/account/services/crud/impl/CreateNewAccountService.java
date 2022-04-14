package com.ctb.api.components.account.services.crud.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.crud.ICreateNewAccountService;
import com.ctb.other.INFO;
import com.ctb.other.log.Logger;
import com.ctb.service.generate.ITokenGenerationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Component
@EnableTransactionManagement
@AllArgsConstructor
public class CreateNewAccountService implements ICreateNewAccountService {

	private final IAccountRepository accountRepository;

	private final ITokenGenerationService tokenGenerator;

	public String registerNewUser(String email, String password, String username) {

		if (emailAlreadyRegistered(email)) {
			Logger.log("ERROR", "E-Mail '" + email + "' already taken");
		}

		String token = tokenGenerator.generate();

		if (token == null) {
			return Logger.log("ERROR", "Token could not be generated");
		}

		AccountDAO newAccount = new AccountDAO();
		newAccount.setEmail(email);
		newAccount.setPassword(password);
		newAccount.setUsername(username);
		newAccount.setToken(token);
		newAccount.setFeedbacks(List.of());
		newAccount.setRecipes(List.of());

		if (createNewTransaction(newAccount)) {
			Logger.log("INFO", INFO.PERSIST_SUCCESS);
			return token;
		}

		return null;
	}

	private boolean emailAlreadyRegistered(String email) {
		return accountRepository.findByEmail(email) != null;
	}

	@Transactional
	boolean createNewTransaction(AccountDAO newAccount) {
		if (saveAccountToDatabase(newAccount)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Logger.log("ERROR", "Transaction Rollback. Error while persisting account");
			return false;
		}
	}

	private boolean saveAccountToDatabase(AccountDAO newAccount) {

		accountRepository.save(newAccount);

		return accountSavedCorrectly(newAccount);
	}

	private boolean accountSavedCorrectly(AccountDAO newAccount) {
		AccountDAO savedInDatabase = accountRepository.findByEmail(newAccount.getEmail());

		return newAccount.getEmail().equals(savedInDatabase.getEmail())
				&& newAccount.getPassword().equals(savedInDatabase.getPassword())
				&& newAccount.getToken().equals(savedInDatabase.getToken())
				&& newAccount.getUsername().equals(savedInDatabase.getUsername());
	}
}
