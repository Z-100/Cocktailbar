package com.ctb.api.components.ingredient.services.crud;

public interface IUpdateExistingAccountService {

	boolean update(String email, String newEmail, String newPassword);
}
