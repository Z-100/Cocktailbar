package com.ctb.api.components.recipe.dto;

import com.ctb.api.components.ingredient.dao.IngredientDAO;

import java.util.HashMap;

public class RecipeDTO {

	private Long id;

	private String title;

	private String description;

	private HashMap<Integer, IngredientDAO> ingredientsMap;
}
