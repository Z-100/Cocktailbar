package com.ctb.api.components.feedback.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedbackDTO {

	private Long id;

	private String title;

	private String description;

	private Integer rating;
}
