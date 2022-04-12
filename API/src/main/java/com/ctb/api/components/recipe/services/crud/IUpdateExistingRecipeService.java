package com.ctb.api.components.recipe.services.crud;

public interface IUpdateExistingRecipeService {

	boolean update(String email, String newEmail, String newPassword);
}
