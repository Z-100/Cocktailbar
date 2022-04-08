package com.ctb.api.components.ingredient.services.crud;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IDeleteExistingAccountService {

	boolean delete(AccountDAO account);
}
