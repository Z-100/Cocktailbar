package com.ctb.api.service.crud.account;

import com.ctb.api.components.account.dto.AccountDTO;

public interface IReadExistingAccountService {

	AccountDTO getAccount(String username);
}
