package com.ctb.api.components.feedback.services.crud.impl;

import com.ctb.api.components.account.repository.IAccountRepository;
import com.ctb.api.components.feedback.dao.FeedbackDAO;
import com.ctb.api.components.feedback.repository.IFeedbackRepository;
import com.ctb.api.components.feedback.services.crud.ICreateNewFeedbackService;
import com.ctb.api.components.recipe.repository.IRecipeRepository;
import com.ctb.service.log.Logger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Objects;

@Component
@AllArgsConstructor
@EnableTransactionManagement
public class CreateNewFeedbackService implements ICreateNewFeedbackService {

	private final IAccountRepository accountRepository;
	private final IFeedbackRepository feedbackRepository;
	private final IRecipeRepository recipeRepository;

	public byte insertNewFeedback(String email, String s_fkRecipeId, String title, String description, String s_rating) {

		final Long fkRecipeId = Long.valueOf(s_fkRecipeId);

		if (feedbackAlreadyExists(email, fkRecipeId)) {
			Logger.log("ERROR", "Feedback already exists on recipe by user with email " + email);
			return 0;
		}

		int rating = Integer.parseInt(s_rating);

		FeedbackDAO newFeedback = new FeedbackDAO();
		newFeedback.setTitle(title);
		newFeedback.setDescription(description);
		newFeedback.setRating(rating);
		newFeedback.setFkRecipeId(recipeRepository.getById(fkRecipeId));
		newFeedback.setFkAccountId(accountRepository.findByEmail(email));

		if (createNewTransaction(newFeedback))
			return 1;

		return 0;
	}

	private Boolean feedbackAlreadyExists(String email, Long fkRecipeId) {
		final Long accountId = accountRepository.findByEmail(email).getId();

		final Boolean[] alreadyExists = { false };

		recipeRepository.getById(fkRecipeId).getFeedbacks().forEach(f -> {
			if (Objects.equals(f.getFkAccountId().getId(), accountId))
				 alreadyExists[0] = true;
		});

		return alreadyExists[0];
	}

	@Transactional
	boolean createNewTransaction(FeedbackDAO newFeedback) {
		if (saveFeedbackToDatabase(newFeedback)) {
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Logger.log("ERROR", "Transaction Rollback. Error whilst persisting feedback");
			return false;
		}
	}

	private boolean saveFeedbackToDatabase(FeedbackDAO newFeedback) {
		feedbackRepository.save(newFeedback);

		return feedbackSavedCorrectly(newFeedback);
	}

	private boolean feedbackSavedCorrectly(FeedbackDAO newFeedback) {
		try {
			FeedbackDAO savedInDatabase = feedbackRepository.getById(newFeedback.getId());

			return newFeedback.getTitle().equals(savedInDatabase.getTitle())
					&& newFeedback.getDescription().equals(savedInDatabase.getDescription())
					&& newFeedback.getFkRecipeId().equals(savedInDatabase.getFkRecipeId())
					&& newFeedback.getFkAccountId().equals(savedInDatabase.getFkAccountId());
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}
}
