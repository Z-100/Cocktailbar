package com.ctb.api.components.recipe.services.crud;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IDeleteExistingRecipeService {

	boolean delete(AccountDAO account);
}
