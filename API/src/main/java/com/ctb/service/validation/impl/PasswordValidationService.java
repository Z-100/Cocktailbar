package com.ctb.service.validation.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.service.log.Logger;
import com.ctb.service.validation.IPasswordValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasswordValidationService implements IPasswordValidationService {

	private final IAccountRepository repository;

	public AccountDAO validate(String email, String password) {

		AccountDAO accountFromDB = repository.findByEmail(email);

		if (accountFromDB == null) {
			Logger.log("ERROR", "Failed to retrieve account with email " + email);
			return null;
		}

		if (accountFromDB.getEmail().equals(email) && accountFromDB.getPassword().equals(password))
			return accountFromDB;

		return null;
	}

	public AccountDAO validate(String key, String password, String s_isUname) {

		boolean isUname = Boolean.parseBoolean(s_isUname);

		AccountDAO accountFromDB = isUname ?
				repository.findByUsername(key) : repository.findByEmail(key);


		if (accountFromDB == null) {
			Logger.log("ERROR", "Failed to retrieve account with username " + key);
			return null;
		}

		if (accountFromDB.getEmail().equals(key) && accountFromDB.getPassword().equals(password))
			return accountFromDB;

		return null;
	}
}
