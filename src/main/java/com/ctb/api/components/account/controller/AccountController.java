package com.ctb.api.components.account.controller;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.mapper.AAccountMapper;
import com.ctb.api.service.crud.account.RegisterNewAccountService;
import com.ctb.other.replacement.JsonBoolean;
import com.ctb.service.validation.IPasswordValidationService;
import com.ctb.service.validation.impl.PasswordValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final IAccountRepository repository;
	private final AAccountMapper mapper;

	private final IPasswordValidationService pwValidation;
	private final RegisterNewAccountService registerAccount;

	@GetMapping("/login")
	public AccountDTO login(
			@RequestHeader("email") final String email,
			@RequestHeader("password") final String password) {

		AccountDAO accountFromDB = pwValidation.validate(email, password);

		return accountFromDB != null ? mapper.toDTO(accountFromDB) : null;
	}

	@GetMapping("/register")
	public JsonBoolean register(
			@RequestHeader final String email,
			@RequestHeader final String password) {

		return registerAccount.register(email, password) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}
}

