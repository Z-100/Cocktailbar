package com.ctb.api.components.recipe.controller;

import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.other.API;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(URL.RECIPE)
@AllArgsConstructor
public class RecipeController {

	@GetMapping(API.INSERT)
	public JsonBoolean insertNewRecipe() {

		return null;
	}

	@GetMapping(API.UPDATE)
	public JsonBoolean updateRecipe() {

		return null;
	}

	@GetMapping(API.DELETE)
	public JsonBoolean deleteRecipe() {

		return null;
	}

	@GetMapping(API.GET + API.ALL)
	public List<RecipeDTO> getAllRecipes() {

		return null;
	}

	@GetMapping(API.GET + API.ALL + "{email}")
	public List<RecipeDTO> getAllRecipesFromUser(@PathVariable String email) {

		return null;
	}

	@GetMapping(API.GET + API.RECOMMENDED)
	public List<RecipeDTO> getRecommendedRecipes() {

		return null;
	}
}
