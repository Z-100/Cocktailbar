package com.ctb.api.components.recipe.services.mapper;

import com.ctb.api.components.recipe.dao.RecipeDAO;
import com.ctb.api.components.recipe.dto.RecipeDTO;
import org.junit.Ignore;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ARecipeMapper {

	@InheritInverseConfiguration
	abstract public RecipeDTO toDTO(RecipeDAO entity);

	@Mapping(target = "fkAccountId", ignore = true)
	abstract public RecipeDAO toEntity(RecipeDTO dto);
}
