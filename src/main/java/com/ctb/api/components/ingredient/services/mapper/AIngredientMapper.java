package com.ctb.api.components.ingredient.services.mapper;

import com.ctb.api.components.ingredient.dao.IngredientDAO;
import com.ctb.api.components.ingredient.dto.IngredientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AIngredientMapper {

	abstract public IngredientDTO toDTO(IngredientDAO entity);

	abstract public IngredientDAO toEntity(IngredientDTO dto);
}
