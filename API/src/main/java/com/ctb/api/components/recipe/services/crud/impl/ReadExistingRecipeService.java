package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.api.components.recipe.services.crud.IReadExistingRecipeService;
import com.ctb.api.components.recipe.services.mapper.ARecipeMapper;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReadExistingRecipeService implements IReadExistingRecipeService {

	private final IRecipeRepository recipeRepository;
	private final ARecipeMapper mapper;

	public List<RecipeDTO> getRecipes(String type, String s_fkAccountId) {
		return switch (type) {
			case "all" -> getAll();
			case "user" -> getAllFromUser(s_fkAccountId);
			case "recommended" -> getRecommended();
			case "latest" -> getLatestTen();
			default -> handleError("Invalid type " + type);
		};
	}

	private List<RecipeDTO> handleError(String message) {
		Logger.log("ERROR", message);
		return null;
	}

	private List<RecipeDTO> getAll() {
		List<?> recipeDTOs = recipeRepository.findAll();

		recipeDTOs.forEach(r -> mapper.toDTO((RecipeDAO) r));

		if (recipeDTOs.isEmpty())
			handleError("ALL recipes not found");

		return (List<RecipeDTO>) recipeDTOs;
	}

	private List<RecipeDTO> getAllFromUser(String s_fkAccountId) {
		try {
			List<?> recipeDTOs = recipeRepository.findAllByFkAccountId(Long.valueOf(s_fkAccountId));

			recipeDTOs.forEach(r -> mapper.toDTO((RecipeDAO) r));

			if (recipeDTOs.isEmpty())
				handleError("ALL recipes FROM USER not found");

			return (List<RecipeDTO>) recipeDTOs;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<RecipeDTO> getRecommended() {
		List<?> recipeDTOs = recipeRepository.getTop10OrderByRand();

		recipeDTOs.forEach(r -> mapper.toDTO((RecipeDAO) r));

		if (recipeDTOs.isEmpty())
			handleError("RECOMMENDED recipes not found");

		return (List<RecipeDTO>) recipeDTOs;
	}

	private List<RecipeDTO> getLatestTen() {
		List<?> recipeDTOs = recipeRepository.getTop10OrderByIdDesc();

		recipeDTOs.forEach(r -> mapper.toDTO((RecipeDAO) r));

		if (recipeDTOs.isEmpty())
			handleError("LATEST TEN recipes not found");

		return (List<RecipeDTO>) recipeDTOs;
	}
}
