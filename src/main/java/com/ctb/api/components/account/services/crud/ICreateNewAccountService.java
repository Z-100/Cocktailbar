package com.ctb.api.components.account.services.crud;

public interface ICreateNewAccountService {

	String registerNewUser(String email, String password, String username);
}
