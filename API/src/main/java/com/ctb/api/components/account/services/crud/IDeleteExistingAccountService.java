package com.ctb.api.components.account.services.crud;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IDeleteExistingAccountService {

	boolean delete(AccountDAO account);
}
