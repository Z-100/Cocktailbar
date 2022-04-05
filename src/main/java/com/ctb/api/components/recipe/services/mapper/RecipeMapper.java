package com.ctb.api.components.recipe.services.mapper;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RecipeMapper {

	abstract public RecipeDTO toDTO(RecipeDAO entity);

	abstract public RecipeDAO toEntity(RecipeDTO dto);
}
