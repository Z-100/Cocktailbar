package com.ctb.api.components.recipe.dto;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.feedback.dto.FeedbackDTO;
import com.ctb.api.components.other.dao.RecipeIngredient;

import java.util.List;

public class RecipeDTO {

	private Long id;

	private String title;

	private String description;

	private AccountDAO fkAccountId;

	private List<RecipeIngredient> recipes;

	private List<FeedbackDTO> feedbacks;
}
