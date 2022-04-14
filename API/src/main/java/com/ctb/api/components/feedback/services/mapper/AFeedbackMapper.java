package com.ctb.api.components.feedback.services.mapper;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.feedback.dto.FeedbackDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AFeedbackMapper {

	@InheritInverseConfiguration
	abstract public FeedbackDTO toDTO(FeedbackDAO entity);
	//TODO MAKE WORK WITHOUT fkAccountId
	@Mapping(target = "fkAccountId", ignore = true)
	@Mapping(target = "fkRecipeId", ignore = true)
	abstract public FeedbackDAO toEntity(FeedbackDTO dto);
}
