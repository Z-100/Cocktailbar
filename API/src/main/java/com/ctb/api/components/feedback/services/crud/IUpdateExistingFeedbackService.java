package com.ctb.api.components.feedback.services.crud;

public interface IUpdateExistingFeedbackService {

	boolean update(String email, String newEmail, String newPassword);
}
