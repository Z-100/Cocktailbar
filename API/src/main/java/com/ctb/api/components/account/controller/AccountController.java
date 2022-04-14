package com.ctb.api.components.account.controller;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.services.crud.ICreateNewAccountService;
import com.ctb.api.components.account.services.crud.IDeleteExistingAccountService;
import com.ctb.api.components.account.services.crud.IReadExistingAccountService;
import com.ctb.api.components.account.services.crud.IUpdateExistingAccountService;
import com.ctb.other.API;
import com.ctb.other.Response;
import com.ctb.other.URL;
import com.ctb.service.validation.IPasswordValidationService;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


	// ? Returns Token
	@PostMapping(API.LOGIN)
	public ResponseEntity<?> login(
			@RequestHeader("email") final String email,
			@RequestHeader("password") final String password) {

		AccountDAO accountDAO = pwValidation.validate(email, password);

		if (accountDAO == null)
			return new ResponseEntity<>(Response.INVALID_PASSWORD, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(accountDAO.getToken(), HttpStatus.OK);
	}

	@PostMapping(API.REGISTER)
	public ResponseEntity<?> register(
			@RequestHeader("email") final String email,
			@RequestHeader("password") final String password,
			@RequestHeader("username") final String username) {

		String token = createService.registerNewUser(email, password, username);

		if (token == null)
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@GetMapping(API.GET)
	public ResponseEntity<?> getAccount(@RequestParam("username") String username) {

		AccountDTO account = readService.getAccount(username);

		if (account == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping(API.DELETE)
	public ResponseEntity<?> deleteAccount(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token) {

		if (!tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (!deleteService.delete(pwValidation.validate(email, password)))
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_DELETE, HttpStatus.OK);
	}

	@PostMapping(API.UPDATE)
	public ResponseEntity<?> updateAccount(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token,
			@RequestHeader("new-email") String newEmail,
			@RequestHeader("new-password") String newPassword) {

		if (!tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (pwValidation.validate(email, password) == null)
			return new ResponseEntity<>(Response.INVALID_PASSWORD, HttpStatus.INTERNAL_SERVER_ERROR);

		if (!updateService.update(email, newEmail, newPassword))
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_UPDATE, HttpStatus.OK);
	}
}

