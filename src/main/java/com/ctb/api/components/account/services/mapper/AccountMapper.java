//package com.ctb.api.components.account.services.mapper;
//
//import com.ctb.api.components.account.dao.AccountDAO;
//import com.ctb.api.components.account.dto.AccountDTO;
//import org.mapstruct.AfterMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingTarget;
//
//@Mapper(implementationName = "AccountMapper",
//		componentModel = "spring")
//public abstract class AccountMapper {
//
//	@Mapping(target = "recipes", ignore = true)
//	abstract public AccountDTO toDTO(AccountDAO entity);
//
//	@Mapping(target = "token", ignore = true)
//	@Mapping(target = "password", ignore = true)
//	@Mapping(target = "recipes", ignore = true)
//	abstract public AccountDAO toEntity(AccountDTO dto);
//
//	@AfterMapping
//	void setMemberToDto(@MappingTarget AccountDTO dto, AccountDAO entity) {
////		dto.setRecipes(entity.getRecipes());
//	}
//
//	@AfterMapping
//	void setMemberToEntity(@MappingTarget AccountDAO entity, AccountDTO dto) {
////		entity.setRecipes(dto.getRecipes());
//	}
//}
