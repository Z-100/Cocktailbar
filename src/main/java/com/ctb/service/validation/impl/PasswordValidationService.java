package com.ctb.service.validation.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.service.validation.IPasswordValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PasswordValidationService implements IPasswordValidationService {

	private final IAccountRepository repository;

	public boolean validate(String email, String password) {

		AccountDAO accountFromDB = repository.findByEmail(email);

		return Objects.equals(accountFromDB.getEmail(), email)
				&& Objects.equals(accountFromDB.getPassword(), password);
	}
}
