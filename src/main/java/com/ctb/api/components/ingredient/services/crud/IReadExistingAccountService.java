package com.ctb.api.components.ingredient.services.crud;

import com.ctb.api.components.account.dto.AccountDTO;

public interface IReadExistingAccountService {

	AccountDTO getAccount(String username);
}
