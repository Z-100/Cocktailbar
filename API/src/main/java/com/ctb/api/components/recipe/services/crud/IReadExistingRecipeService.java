package com.ctb.api.components.recipe.services.crud;

import com.ctb.api.components.account.dto.AccountDTO;

public interface IReadExistingRecipeService {

	AccountDTO getAccount(String username);
}
