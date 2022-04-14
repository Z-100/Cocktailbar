package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.ingredient.repository.IIngredientRepository;
import com.ctb.api.components.other.dao.RecipeIngredient;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.api.components.recipe.services.mapper.ARecipeMapper;
import com.ctb.api.components.recipe.services.crud.ICreateNewRecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableTransactionManagement
@AllArgsConstructor
public class CreateNewRecipeService implements ICreateNewRecipeService {

	private final IAccountRepository accountRepository;
	private final IRecipeRepository recipeRepository;

	public boolean createNewRecipe(String email, String title, String description, String json_ingredients) {

		List<RecipeIngredient> ingredients = new ArrayList<>();
		try {
		/*
		json_ingredients structure
				ingredients[
					name: Ing1 {
						amount: 5
					},
					name: Ing2 {
						amount: 5
					},
				], ...
		 */
			ObjectMapper mapper = new ObjectMapper(); //Does it work? idk
			ingredients.add(mapper.readValue(json_ingredients, RecipeIngredient.class));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return false;
		}

		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.setTitle(title);
		recipeDAO.setDescription(description);
		recipeDAO.setFkAccountId(accountRepository.findByEmail(email));
		recipeDAO.setIngredients(ingredients);
		recipeDAO.setFeedbacks(List.of());

		return createNewTransaction(recipeDAO);
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
		RecipeDAO fromDatabase = recipeRepository.findByRecipeId(recipe.getId());

		return recipe.getTitle().equals(fromDatabase.getTitle())
				&& recipe.getDescription().equals(fromDatabase.getDescription());
	}
}
