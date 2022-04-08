package com.ctb.api.components.account.controller;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.services.mapper.AAccountMapper;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.service.crud.account.RegisterNewAccountService;
import com.ctb.other.API;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import com.ctb.service.validation.IPasswordValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URL.ACCOUNT)
@AllArgsConstructor
public class AccountController {

	private final AAccountMapper mapper;

	private final IPasswordValidationService pwValidation;
	private final RegisterNewAccountService registerAccount;

	@GetMapping(API.LOGIN)
	public AccountDTO login(
			@RequestHeader("email") final String email,
			@RequestHeader("password") final String password) {

		AccountDAO accountFromDB = pwValidation.validate(email, password);

		return accountFromDB != null ? mapper.toDTO(accountFromDB) : null;
	}

	@GetMapping(API.REGISTER)
	public JsonBoolean register(
			@RequestHeader final String email,
			@RequestHeader final String password) {

		return registerAccount.register(email, password) ?
				new JsonBoolean(true) : new JsonBoolean(false);
	}

	@GetMapping(API.DELETE)
	public List<RecipeDTO> deleteAccount() {

		return null;
	}

	@GetMapping(API.UPDATE)
	public List<RecipeDTO> updateAccount() {

		return null;
	}
}

