package com.ctb.service.validation.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.service.log.Logger;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
@AllArgsConstructor
public class TokenValidationService implements ITokenValidationService {

	private final IAccountRepository repository;

	public boolean validate(String email, String token) {

		BiFunction<AccountDAO, String, Boolean> validate =
				(a, t) -> a.getToken().equals(t);

		AccountDAO account = repository.findByEmail(email);

		if (account == null) {
			Logger.log("Error", "Failed to retrieve account with email '" + email + "'\nLocation: TokenValidationService.java");
			return false;
		}

		if (validate.apply(account, token))
			return true;

		Logger.log("Error", "Failed to validate account with email '" + email + "' and token '" + token + "'\nLocation: TokenValidationService.java");
		return false;
	}
}
