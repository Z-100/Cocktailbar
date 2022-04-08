package com.ctb.api.components.feedback.services.crud;

public interface IUpdateExistingAccountService {

	boolean update(String email, String newEmail, String newPassword);
}
