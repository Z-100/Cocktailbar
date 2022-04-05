package com.ctb.api.components.account.services.mapper;

import com.ctb.api.components.account.dao.AccountDAO;
import com.ctb.api.components.account.dto.AccountDTO;
import com.ctb.api.components.recipe.services.mapper.RecipeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RecipeMapper.class)
public abstract class AAccountMapper {

	abstract public AccountDTO toDTO(AccountDAO entity);

	@Mapping(target = "token", ignore = true)
	@Mapping(target = "password", ignore = true)
	abstract public AccountDAO toEntity(AccountDTO dto);
}
