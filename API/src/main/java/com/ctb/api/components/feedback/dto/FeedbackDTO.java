package com.ctb.api.components.feedback.dto;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.recipe.dao.RecipeDAO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackDTO {

	private Long id;

	private String title;

	private String description;

	private Integer rating;

	private AccountDAO fkAccountId;

	private RecipeDAO fkRecipeId;
}
