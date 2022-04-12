package com.ctb.api.components.account.services.crud;

public interface IUpdateExistingAccountService {

	boolean update(String email, String newEmail, String newPassword);
}
