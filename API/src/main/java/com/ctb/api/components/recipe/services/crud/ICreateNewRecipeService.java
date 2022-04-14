package com.ctb.api.components.recipe.services.crud;

public interface ICreateNewRecipeService {

	boolean createNewRecipe(String email, String title, String description, String json_ingredients);
}
