package com.ctb.api.service.crud.account.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.mapper.AAccountMapper;
import com.ctb.api.service.crud.account.ICreateNewAccountService;
import com.ctb.api.service.crud.account.IReadExistingAccountService;
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
			return null;

		return mapper.toDTO(accountFromDB);
	}
}
