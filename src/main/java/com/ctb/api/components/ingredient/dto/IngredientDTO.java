package com.ctb.api.components.ingredient.dto;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {

	private Long id;

	private String name;

	private String type;

	private RecipeDAO fkRecipeId;
}
