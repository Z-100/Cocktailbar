package com.ctb.service.generate.impl;

import com.ctb.other.log.Logger;
import com.ctb.service.generate.ITokenGenerationService;
import com.ctb.service.stupidity.ITokenGenerationHelperService;
import com.ctb.service.stupidity.impl.TokenGenerationHelperService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenGenerationService implements ITokenGenerationService {

	@Override
	public String generate() {
		String uuid = UUID.randomUUID().toString();

		String[] parts = uuid.split("-", 3);

		String specialSecretTokenIngredient =
				TokenGenerationHelperService.generateSpecialSecretTokenIngredient();

		String token = String.format("%s%s%s", parts[0], specialSecretTokenIngredient, parts[2]);

		if (token.length() == 39) {
			Logger.log("INFO", "Token has been successfully generated");
			return token;
		}

		Logger.log("ERROR", "Error creating token");

		return null;
	}
}
