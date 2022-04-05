package com.ctb.api.components.recipe.dao;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.other.dao.RecipeIngredient;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class RecipeDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "fkAccountId")
	@JsonManagedReference
	private AccountDAO fkAccountId;

	@OneToMany(mappedBy = "fkRecipeId",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RecipeIngredient> recipes = new ArrayList<>();

//	public void addRecipe(IngredientDAO ingredient) {
//		RecipeIngredient recipeIngredient = new RecipeIngredient(this, ingredient);
//		recipes.add(recipeIngredient);
//		ingredient.getIngredients().add(recipeIngredient);
//	}
//
//	public void removeRecipe(IngredientDAO ingredient) {
//		for (Iterator<RecipeIngredient> iterator = recipes.iterator(); iterator.hasNext(); ) {
//
//			RecipeIngredient recipeIngredient = iterator.next();
//
//			if (recipeIngredient.getFkRecipeId().equals(this) &&
//					recipeIngredient.getFkIngredientId().equals(ingredient)) {
//				iterator.remove();
//				recipeIngredient.getFkIngredientId().getIngredients().remove(recipeIngredient);
//				recipeIngredient.setFkRecipeId(null);
//				recipeIngredient.setFkIngredientId(null);
//			}
//		}
//	}
}
