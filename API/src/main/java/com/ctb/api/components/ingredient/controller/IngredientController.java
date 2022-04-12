package com.ctb.api.components.ingredient.controller;

import com.ctb.api.components.ingredient.dto.IngredientDTO;
import com.ctb.other.API;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URL.INGREDIENT)
@AllArgsConstructor
public class IngredientController {

	@GetMapping(API.INSERT)
	public JsonBoolean insertNewIngredient() {

		return null;
	}

	@GetMapping(API.UPDATE)
	public JsonBoolean updateIngredient() {

		return null;
	}

	@GetMapping(API.DELETE)
	public JsonBoolean deleteIngredient() {

		return null;
	}

	@GetMapping(API.GET + API.ALL)
	public List<IngredientDTO> getAllIngredients() {

		return null;
	}

	@GetMapping(API.GET + API.ALL + "{recipeId}")
	public List<IngredientDTO> getAllSpecificIngredients() {

		return null;
	}
}
