package com.ctb.api.components.account.dto;

import com.ctb.api.components.recipe.dto.RecipeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AccountDTO {

	private Long id;

	private String email;

	private List<RecipeDTO> recipes;
}
