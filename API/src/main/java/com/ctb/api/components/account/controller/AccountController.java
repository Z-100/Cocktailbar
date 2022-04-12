package com.ctb.api.components.account.controller;

import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.services.crud.*;
import com.ctb.api.components.account.services.crud.ICreateNewAccountService;
import com.ctb.api.components.account.services.crud.IDeleteExistingAccountService;
import com.ctb.api.components.account.services.crud.IReadExistingAccountService;
import com.ctb.api.components.account.services.crud.IUpdateExistingAccountService;
import com.ctb.other.API;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import com.ctb.other.replacement.JsonString;
import com.ctb.service.validation.IPasswordValidationService;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(URL.ACCOUNT)
@AllArgsConstructor
public class AccountController {

	private final IPasswordValidationService pwValidation;
	private final ITokenValidationService tokValidation;

	private final ICreateNewAccountService createService;
	private final IReadExistingAccountService readService;
	private final IUpdateExistingAccountService updateService;
	private final IDeleteExistingAccountService deleteService;


	@PostMapping(API.LOGIN)
	public JsonBoolean login(
			@RequestHeader("email") final String email,
			@RequestHeader("token") final String token,
			@RequestHeader("password") final String password) {

		if (!tokValidation.validate(email, token))
			return new JsonBoolean(false);

		return pwValidation.validate(email, password) != null ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}

	@PostMapping(API.REGISTER)
	public JsonString register(
			@RequestHeader final String email,
			@RequestHeader final String password,
			@RequestHeader final String username) {

		String token = createService.registerNewUser(email, password, username);

		return token != null ? new JsonString(token) : null;
	}

	@GetMapping(API.GET)
	public AccountDTO getAccount(@RequestParam("username") String username) {
		return readService.getAccount(username);
	}

	@PostMapping(API.DELETE)
	public JsonBoolean deleteAccount(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		if (!tokValidation.validate(email, token))
			return new JsonBoolean(false);

		return deleteService.delete(pwValidation.validate(email, password)) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}

	@PostMapping(API.UPDATE)
	public JsonBoolean updateAccount(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token,
			@RequestHeader("new-email") String newEmail,
			@RequestHeader("new-password") String newPassword) {

		if (!tokValidation.validate(email, token))
			return null;

		if (pwValidation.validate(email, password) == null)
			return null;

		return updateService.update(email, newEmail, newPassword) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}
}

