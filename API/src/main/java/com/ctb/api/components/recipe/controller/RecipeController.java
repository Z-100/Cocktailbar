package com.ctb.api.components.recipe.controller;

import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.api.components.recipe.services.crud.ICreateNewRecipeService;
import com.ctb.api.components.recipe.services.crud.IDeleteExistingRecipeService;
import com.ctb.api.components.recipe.services.crud.IReadExistingRecipeService;
import com.ctb.api.components.recipe.services.crud.IUpdateExistingRecipeService;
import com.ctb.other.API;
import com.ctb.other.Response;
import com.ctb.other.URL;
import com.ctb.service.validation.IPasswordValidationService;
import com.ctb.service.validation.ITokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URL.RECIPE)
@AllArgsConstructor
public class RecipeController {

	private final IPasswordValidationService pwValidation;
	private final ITokenValidationService tokValidation;

	private final ICreateNewRecipeService createService;
	private final IReadExistingRecipeService readService;
	private final IUpdateExistingRecipeService updateService;
	private final IDeleteExistingRecipeService deleteService;

	@PostMapping(API.INSERT)
	public ResponseEntity<?> insertNewRecipe(
			@RequestHeader("email") String email,
			@RequestHeader("token") String token,
			@RequestHeader("title") String title,
			@RequestHeader("description") String description,
			@RequestHeader("ingredients") String json_ingredients) {

		if (!tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (!createService.createNewRecipe(email, title, description, json_ingredients))
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_INSERT, HttpStatus.OK);
	}

	@PostMapping(API.DELETE)
	public ResponseEntity<?> deleteRecipe(
			@RequestHeader("email") String email,
			@RequestHeader("password") String password,
			@RequestHeader("token") String token,
			@RequestHeader("recipe-id") String recipeId) {

		if (!tokValidation.validate(email, token))
			return new ResponseEntity<>(Response.INVALID_TOKEN, HttpStatus.INTERNAL_SERVER_ERROR);

		if (pwValidation.validate(email, password) == null)
			return new ResponseEntity<>(Response.INVALID_PASSWORD, HttpStatus.INTERNAL_SERVER_ERROR);

		if (!deleteService.delete(recipeId))
			return new ResponseEntity<>(Response.SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(Response.SUCCESS_DELETE, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.ALL)
	public ResponseEntity<?> getAllRecipes() {

		List<RecipeDTO> recipes = readService.getRecipes("all", null);

		if (recipes == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.ALL + "/{account-id}")
	public ResponseEntity<?> getAllRecipesFromUser(
			@PathVariable("account-id") String id) {

		List<RecipeDTO> recipes = readService.getRecipes("user", id);

		if (recipes == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.RECOMMENDED)
	public ResponseEntity<?> getRecommendedRecipes() {

		List<RecipeDTO> recipes = readService.getRecipes("recommended", null);

		if (recipes == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping(API.GET + API.LATEST)
	public ResponseEntity<?> getLatestTenRecipes() {

		List<RecipeDTO> recipes = readService.getRecipes("latest", null);

		if (recipes == null)
			return new ResponseEntity<>(Response.NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	//	@GetMapping(API.UPDATE) //TODO: Implement in future
	public ResponseEntity<?> updateRecipe() {
		return null;
	}
}
