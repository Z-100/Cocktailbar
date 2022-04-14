package com.ctb.api.components.recipe.services.crud;

import com.ctb.api.components.recipe.dto.RecipeDTO;

import java.util.List;

public interface IReadExistingRecipeService {

	List<RecipeDTO> getRecipes(String type, String fkAccountId);
}
