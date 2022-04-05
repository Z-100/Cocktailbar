package com.ctb.service.validation.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.other.exception.PrintExceptionService;
import com.ctb.service.validation.IPasswordValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasswordValidationService implements IPasswordValidationService {

	private final IAccountRepository repository;

	public AccountDAO validate(String email, String password) {
		try {
			AccountDAO accountFromDB = repository.findByEmail(email);

			if (accountFromDB == null)
				throw new NullPointerException();

			if (accountFromDB.getEmail().equals(email) && accountFromDB.getPassword().equals(password))
				return accountFromDB;
		} catch (NullPointerException e) {
			PrintExceptionService.print("Failed to retrieve account with email " + email, e.getStackTrace());
		}
		return null;
	}
}
