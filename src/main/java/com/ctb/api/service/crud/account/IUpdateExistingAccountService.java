package com.ctb.api.service.crud.account;

public interface IUpdateExistingAccountService {

	boolean update(String email, String newEmail, String newPassword);
}
