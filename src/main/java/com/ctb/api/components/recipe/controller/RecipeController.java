package com.ctb.api.components.recipe.controller;

import com.ctb.api.components.recipe.dto.RecipeDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {

	@GetMapping("/insert-new")
	public List<RecipeDTO> insertNewRecipe() {

		return null;
	}

	@GetMapping("/update")
	public List<RecipeDTO> updateRecipe() {

		return null;
	}

	@GetMapping("/delete")
	public List<RecipeDTO> deleteRecipe() {

		return null;
	}

	@GetMapping("/get-all")
	public List<RecipeDTO> getAllRecipes() {

		return null;
	}

	@GetMapping("/get-all{email}")
	public List<RecipeDTO> getAllRecipesFromUser(@PathVariable String email) {

		return null;
	}

	@GetMapping("/get-recommended")
	public List<RecipeDTO> getRecommendedRecipes() {

		return null;
	}
}
