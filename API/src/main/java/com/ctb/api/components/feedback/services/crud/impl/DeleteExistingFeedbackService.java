package com.ctb.api.components.feedback.services.crud.impl;

import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.feedback.repository.IFeedbackRepository;
import com.ctb.api.components.feedback.services.crud.IDeleteExistingFeedbackService;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@AllArgsConstructor
@Component
public class DeleteExistingFeedbackService implements IDeleteExistingFeedbackService {

	private final IFeedbackRepository feedbackRepository;

	public byte delete(String s_id) {
		Long id = Long.valueOf(s_id);

		FeedbackDAO feedback = feedbackRepository.findByFeedbackId(id);

		return (byte) (createNewTransaction(feedback) ? 1 : 0);
	}

	@Transactional
	boolean createNewTransaction(FeedbackDAO feedback) {
		if (deleteFeedback(feedback)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Logger.log("ERROR", "Error whilst deleting feedback");
			return false;
		}
	}

	private boolean deleteFeedback(FeedbackDAO feedback) {

		feedback.setFkAccountId(null);
		feedback.setFkRecipeId(null);

		feedbackRepository.delete(feedback);

		return feedbackDeletedCorrectly(feedback);
	}

	private boolean feedbackDeletedCorrectly(FeedbackDAO feedback) {
		return feedbackRepository.findByFeedbackId(feedback.getId()) == null;
	}
}
