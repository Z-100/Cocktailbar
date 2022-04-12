package com.ctb.service.validation;

public interface ITokenValidationService {

	boolean validate(String email, String token);
}
