package com.ctb.api.components.other.dao;

import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "RecipeIngredient")
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

	@EmbeddedId
	private RecipeIngredientId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fkRecipeId")
	private RecipeDAO recipe;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fkIngredientId")
	private IngredientDAO ingredient;

	@Column(name = "amount")
	private Integer amount;

	public RecipeIngredient(RecipeDAO recipe, IngredientDAO ingredient) {
		this.recipe = recipe;
		this.ingredient = ingredient;
		this.id = new RecipeIngredientId(recipe.getId(), ingredient.getId());
	}
}
