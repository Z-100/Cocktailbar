package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.api.components.recipe.services.crud.IDeleteExistingRecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class DeleteExistingRecipeService implements IDeleteExistingRecipeService {

	private final IRecipeRepository recipeRepository;

	public boolean delete(String s_recipeId) {

		Long recipeId = -1L;

		try {
			recipeId = Long.valueOf(s_recipeId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}

		return createNewTransaction(recipeId);
	}

	@Transactional
	boolean createNewTransaction(Long recipeId) {
		if (deleteAccount(recipeId)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	private boolean deleteAccount(Long recipeId) {

		RecipeDAO recipe = recipeRepository.findByRecipeId(recipeId);
		recipe.setFeedbacks(null);
		recipe.setIngredients(null);

		recipeRepository.delete(recipe);

		return accountDeletedCorrectly(recipe);
	}

	private boolean accountDeletedCorrectly(RecipeDAO recipe) {
		return recipeRepository.findByRecipeId(recipe.getId()) == null;
	}
}
