package com.ctb.api.components.ingredient.controller;

import com.ctb.api.components.recipe.dto.RecipeDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class IngredientController {

	@GetMapping("/insert-new")
	public List<RecipeDTO> insertNewIngredient() {

		return null;
	}

	@GetMapping("/update")
	public List<RecipeDTO> updateIngredient() {

		return null;
	}

	@GetMapping("/delete")
	public List<RecipeDTO> deleteIngredient() {

		return null;
	}

	@GetMapping("/get-all")
	public List<RecipeDTO> getAllIngredients() {

		return null;
	}

	@GetMapping("/get-all{recipe-id}")
	public List<RecipeDTO> getAllSpecificIngredients() {

		return null;
	}
}
