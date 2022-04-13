package com.ctb.api.components.feedback.services.crud.impl;

import com.ctb.api.components.feedback.services.crud.IUpdateExistingFeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Deprecated
@AllArgsConstructor
@Component
public class UpdateExistingFeedbackService implements IUpdateExistingFeedbackService {

	public boolean update() {
		return createNewTransaction();
	}

	@Transactional
	boolean createNewTransaction() {
		if (saveFeedbackToDatabase()) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	private boolean saveFeedbackToDatabase() {
		return feedbackUpdatedCorrectly();
	}

	private boolean feedbackUpdatedCorrectly() {
		return false;
	}
}
