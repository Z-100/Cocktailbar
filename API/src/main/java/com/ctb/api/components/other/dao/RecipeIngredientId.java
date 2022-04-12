package com.ctb.api.components.other.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientId implements Serializable {

	@Column(name = "fk_recipeId")
	private Long fkRecipeId;

	@Column(name = "fk_ingredientId")
	private Long fkIngredientId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass())
			return false;

		RecipeIngredientId that = (RecipeIngredientId) o;
		return Objects.equals(fkRecipeId, that.fkRecipeId) &&
				Objects.equals(fkIngredientId, that.fkIngredientId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkRecipeId, fkIngredientId);
	}
}
