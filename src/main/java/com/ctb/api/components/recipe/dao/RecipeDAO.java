package com.ctb.api.components.recipe.dao;

import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.other.dao.RecipeIngredient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
public class RecipeDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "amount", nullable = false)
	private Long amount;

	@OneToMany(mappedBy = "fkRecipeId",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RecipeIngredient> recipes = new ArrayList<>();

	public void addRecipe(IngredientDAO ingredient) {
		RecipeIngredient recipeIngredient = new RecipeIngredient(this, ingredient);
		recipes.add(recipeIngredient);
		ingredient.getIngredients().add(recipeIngredient);
	}

	public void removeTag(IngredientDAO ingredient) {
		for (Iterator<RecipeIngredient> iterator = recipes.iterator(); iterator.hasNext(); ) {

			RecipeIngredient recipeIngredient = iterator.next();

			if (recipeIngredient.getRecipe().equals(this) &&
					recipeIngredient.getIngredient().equals(ingredient)) {
				iterator.remove();
				recipeIngredient.getIngredient().getIngredients().remove(recipeIngredient);
				recipeIngredient.setRecipe(null);
				recipeIngredient.setIngredient(null);
			}
		}
	}
}
