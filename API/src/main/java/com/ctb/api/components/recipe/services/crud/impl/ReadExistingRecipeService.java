package com.ctb.api.components.recipe.services.crud.impl;

import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.api.components.recipe.services.crud.IReadExistingRecipeService;
import com.ctb.api.components.recipe.services.mapper.ARecipeMapper;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ReadExistingRecipeService implements IReadExistingRecipeService {

	private final IRecipeRepository recipeRepository;
	private final IAccountRepository accountRepository;
	private final ARecipeMapper mapper;

	public List<RecipeDTO> getRecipes(String type, String s_fkAccountId) {
		return switch (type) {
			case "all" -> getAll();
			case "user" -> getAllFromUser(Long.valueOf(s_fkAccountId));
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

	private List<RecipeDTO> getAllFromUser(Long fkAccountId) {
		try {
			List<?> recipeDTOs = recipeRepository.getAllByFkAccountId(accountRepository.findById(fkAccountId).get());

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

		long recipeCount = recipeRepository.count();
		int rdm = (int) (Math.random() * recipeCount);

		Page<RecipeDAO> recipeDAOsPage = recipeRepository.findAll(PageRequest.of(rdm, 10));

		List<RecipeDTO> recipeDTOs = new ArrayList<>();
		if (recipeDAOsPage.hasContent())
			recipeDAOsPage.getContent().forEach(dao -> recipeDTOs.add(mapper.toDTO(dao)));

		if (recipeDAOsPage.isEmpty())
			handleError("RECOMMENDED recipes not found");



		return (List<RecipeDTO>) recipeDTOs;
	}

	private List<RecipeDTO> getLatestTen() {
		List<?> recipeDTOs = recipeRepository.getTop10ByOrderByIdDesc();

		recipeDTOs.forEach(r -> mapper.toDTO((RecipeDAO) r));

		if (recipeDTOs.isEmpty())
			handleError("LATEST TEN recipes not found");

		return (List<RecipeDTO>) recipeDTOs;
	}
}
