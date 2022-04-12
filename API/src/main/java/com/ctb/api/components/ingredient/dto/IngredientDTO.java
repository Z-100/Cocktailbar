package com.ctb.api.components.ingredient.dto;

import com.ctb.api.components.other.dao.RecipeIngredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IngredientDTO {

	private Long id;

	private String name;

	private String type;

	private List<RecipeIngredient> ingredients;
}
