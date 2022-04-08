package com.ctb.api.components.feedback.controller;

import com.ctb.api.components.feedback.dto.FeedbackDTO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import com.ctb.other.API;
import com.ctb.other.URL;
import com.ctb.other.replacement.JsonBoolean;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URL.FEEDBACK)
@AllArgsConstructor
public class FeedbackController {

	@GetMapping(API.INSERT)
	public FeedbackDTO insertNewFeedback() {

		return null;
	}

	@GetMapping(API.DELETE)
	public JsonBoolean deleteFeedback() {

		return null;
	}

	@GetMapping(API.UPDATE)
	public JsonBoolean updateFeedback() {

		return null;
	}

	@GetMapping(API.GET + API.ALL + "{email}")
	public List<RecipeDTO> getAllFeedbackFromAccount() {

		return null;
	}

	@GetMapping(API.GET + API.ALL + "{recipeId}")
	public List<RecipeDTO> getAllFeedbackFromRecipe() {

		return null;
	}
}

