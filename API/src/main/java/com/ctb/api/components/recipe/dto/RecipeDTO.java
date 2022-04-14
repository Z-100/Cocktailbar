package com.ctb.api.components.recipe.dto;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.feedback.dto.FeedbackDTO;
import com.ctb.api.components.other.dao.RecipeIngredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RecipeDTO {

	private Long id;

	private String title;

	private String description;

	private List<RecipeIngredient> ingredients;

	private List<FeedbackDTO> feedbacks;
}
