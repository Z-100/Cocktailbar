package com.ctb.api.components.feedback.services.crud.impl;

import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.feedback.dto.FeedbackDTO;
import com.ctb.api.components.feedback.repository.IFeedbackRepository;
import com.ctb.api.components.feedback.services.crud.IReadExistingFeedbackService;
import com.ctb.api.components.feedback.services.mapper.AFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ReadExistingFeedbackService implements IReadExistingFeedbackService {

	private final IFeedbackRepository repository;
	private final IAccountRepository accountRepository;
	private final AFeedbackMapper mapper;

	public List<FeedbackDTO> getFeedbacks(Object searchTerm) {

		List<FeedbackDAO> feedbackDAOs = new ArrayList<>();
		List<FeedbackDTO> feedbackDTOs = new ArrayList<>();

		// For account email
		if (searchTerm.getClass() == String.class)
			feedbackDAOs = repository.findByFkAccountId(accountRepository.findByEmail(String.valueOf(searchTerm)).getId());

		// For recipe id
		if (searchTerm.getClass() == Long.class)
			feedbackDAOs = repository.findByFkAccountId(accountRepository.findByEmail(String.valueOf(searchTerm)).getId());

		if (feedbackDAOs == null)
			return null;

		feedbackDAOs.forEach(f -> feedbackDTOs.add(mapper.toDTO(f)));

		return feedbackDTOs;
	}
}
