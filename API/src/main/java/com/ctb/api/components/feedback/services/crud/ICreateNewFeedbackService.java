package com.ctb.api.components.feedback.services.crud;

public interface ICreateNewFeedbackService {

	byte insertNewFeedback(String email, String fkRecipeId, String title, String description, String rating);
}
