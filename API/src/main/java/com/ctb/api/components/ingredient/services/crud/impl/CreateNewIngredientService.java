package com.ctb.api.components.ingredient.services.crud.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.ingredient.services.crud.ICreateNewIngredientService;
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
public class CreateNewIngredientService implements ICreateNewIngredientService {

	private final IAccountRepository accountRepository;

	private final ITokenGenerationService tokenGenerator;

	public String registerNewUser(String email, String password, String username) {

		if (emailAlreadyRegistered(email))
			return null;

		String token = tokenGenerator.generate();

		if (token == null)
			return null;

		AccountDAO newAccount = new AccountDAO();

		newAccount.setEmail(email);
		newAccount.setPassword(password);
		newAccount.setUsername(username);
		newAccount.setToken(token);

		newAccount.setFeedbacks(List.of());
		newAccount.setRecipes(List.of());

		if (createNewTransaction(newAccount))
			return token;

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
