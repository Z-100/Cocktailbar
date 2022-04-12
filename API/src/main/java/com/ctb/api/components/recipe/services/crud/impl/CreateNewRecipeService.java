package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.ingredient.repository.IIngredientRepository;
import com.ctb.api.components.other.dao.RecipeIngredient;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.api.components.recipe.services.mapper.ARecipeMapper;
import com.ctb.api.components.recipe.services.crud.ICreateNewRecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

// TODO
@Component
@EnableTransactionManagement
@AllArgsConstructor
public class CreateNewRecipeService implements ICreateNewRecipeService {

	private final IAccountRepository accountRepository;
	private final IRecipeRepository recipeRepository;
	private final IIngredientRepository ingredientRepository;

	private final ARecipeMapper mapper;

	public byte registerNewUser(String email, String title, String description, String stringifiedIngredients) {

		/*
		stringifiedIngredients structure

			fkRecipeId: 3 {
				ingredients[
					name: Ing1 {
						amount: 5
					},
					name: Ing2 {
						amount: 5
					},
				],
			}

		 */

		List<RecipeIngredient> ingredients = /* Map JSON */ null;

		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setTitle(title);
		recipeDTO.setDescription(description);
		recipeDTO.setIngredients(ingredients);
		recipeDTO.setFeedbacks(List.of());
		recipeDTO.setFkAccountId(accountRepository.findByEmail(email));

		RecipeDAO recipeDAO = mapper.toEntity(recipeDTO);

		if (createNewTransaction(recipeDAO))
			return 1;

		return 0;
	}

	@Transactional
	boolean createNewTransaction(RecipeDAO recipe) {
		if (saveAccountToDatabase(recipe)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	private boolean saveAccountToDatabase(RecipeDAO recipe) {

		recipeRepository.save(recipe);

		return recipeSavedCorrectly(recipe);
	}

	private boolean recipeSavedCorrectly(RecipeDAO recipe) {
		return true;
	}
}
