package com.ctb.service.validation.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.other.exception.PrintExceptionService;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
@AllArgsConstructor
public class TokenValidationService implements ITokenValidationService {

	private IAccountRepository repository;

	@Override
	public boolean validate(String email, String token) {

		BiFunction<AccountDAO, String, Boolean> validate =
				(a, t) -> a.getToken().equals(t);

		try {
			AccountDAO account = repository.findByEmail(email);

			if (account == null)
				throw new NullPointerException("[ERROR] Failed to retrieve account with email ");

			if (validate.apply(account, token))
				return true;

		} catch (NullPointerException e) {
			PrintExceptionService.print(e.getMessage() + email, e.getStackTrace());
		}
		return false;
	}
}
