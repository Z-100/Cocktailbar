package com.ctb.api.components.account.services.crud.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.mapper.AAccountMapper;
import com.ctb.api.components.account.services.crud.IReadExistingAccountService;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReadExistingAccountService implements IReadExistingAccountService {

	private final IAccountRepository repository;
	private final AAccountMapper mapper;

	public AccountDTO getAccount(String username) {

		AccountDAO accountFromDB = repository.findByUsername(username);

		if (accountFromDB == null)
			accountFromDB = repository.findByEmail(username);

		if (accountFromDB == null) {
			Logger.log("ERROR", "No account was found with username " + username);
			return null;
		}

		return mapper.toDTO(accountFromDB);
	}
}
