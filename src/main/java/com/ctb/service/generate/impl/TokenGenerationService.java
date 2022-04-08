package com.ctb.service.generate.impl;

import com.ctb.service.generate.ITokenGenerationService;
import com.ctb.service.stupidity.ITokenGenerationHelperService;

import java.util.UUID;

public class TokenGenerationService implements ITokenGenerationService {

	@Override
	public String generate() {
		String uuid = UUID.randomUUID().toString();

		String[] parts = uuid.split("-", 3);

		String specialSecretTokenIngredient =
				ITokenGenerationHelperService.generateSpecialSecretTokenIngredient();

		String token = String.format("%s%s%s", parts[0], specialSecretTokenIngredient, parts[2]);

		if (token.length() == 39)
			return token;

		return null;
	}
}
