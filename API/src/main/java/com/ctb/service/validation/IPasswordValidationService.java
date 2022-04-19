package com.ctb.service.validation;

import com.ctb.api.components.account.dao.AccountDAO;

public interface IPasswordValidationService {

	AccountDAO validate(String email, String password);

	AccountDAO validate(String email, String password, String isUname);
}
