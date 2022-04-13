package com.ctb.api.components.feedback.services.crud;

import com.ctb.api.components.feedback.dto.FeedbackDTO;

import java.util.List;

public interface IReadExistingFeedbackService {

	List<FeedbackDTO> getFeedbacks(Object searchTerm);
}
