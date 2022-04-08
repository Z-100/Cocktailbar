package com.ctb.api.components.feedback.services.crud;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IDeleteExistingAccountService {

	boolean delete(AccountDAO account);
}
