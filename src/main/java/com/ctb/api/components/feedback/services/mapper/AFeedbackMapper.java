package com.ctb.api.components.feedback.services.mapper;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.feedback.dto.FeedbackDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AFeedbackMapper {

	abstract public FeedbackDTO toDTO(FeedbackDAO entity);

	abstract public FeedbackDAO toEntity(FeedbackDTO dto);
}
