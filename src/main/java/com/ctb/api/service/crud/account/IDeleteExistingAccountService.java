package com.ctb.api.service.crud.account;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IDeleteExistingAccountService {

	boolean delete(AccountDAO account);
}
