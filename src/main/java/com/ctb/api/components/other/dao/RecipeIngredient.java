package com.ctb.api.components.other.dao;

import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredient")
@NoArgsConstructor
public class RecipeIngredient {

	@EmbeddedId
	private RecipeIngredientId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fkRecipeId")
	private RecipeDAO fkRecipeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fkIngredientId")
	private IngredientDAO fkIngredientId;

	@Column(name = "amount")
	private Integer amount;

	public RecipeIngredient(RecipeDAO fkRecipeId, IngredientDAO fkIngredientId) {
		this.fkRecipeId = fkRecipeId;
		this.fkIngredientId = fkIngredientId;
		this.id = new RecipeIngredientId(fkRecipeId.getId(), fkIngredientId.getId());
	}
}
