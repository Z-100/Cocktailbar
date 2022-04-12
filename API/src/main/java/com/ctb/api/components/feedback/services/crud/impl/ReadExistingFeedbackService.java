package com.ctb.api.components.feedback.services.crud.impl;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.account.services.mapper.AAccountMapper;
import com.ctb.api.components.feedback.services.crud.IReadExistingFeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReadExistingFeedbackService implements IReadExistingFeedbackService {

	private final IAccountRepository repository;
	private final AAccountMapper mapper;

	public AccountDTO getAccount(String username) {

		AccountDAO accountFromDB = repository.findByUsername(username);

		if (accountFromDB == null)
			return null;

		return mapper.toDTO(accountFromDB);
	}
}
