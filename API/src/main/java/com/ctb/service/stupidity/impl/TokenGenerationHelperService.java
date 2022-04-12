package com.ctb.service.stupidity.impl;

import com.ctb.service.stupidity.ITokenGenerationHelperService;

/**
 * @author z-100
 * Class used to generate a safe "token-password"
 * Some may say this is very unnecessary. And indeed it is.
 * But I was bored; so I did this.
 */
public class TokenGenerationHelperService implements ITokenGenerationHelperService {

	public static String generateSpecialSecretTokenIngredient() {

		byte[] specialSecretTokenIngredientArray = new byte[9];

		specialSecretTokenIngredientArray[0] = specialChar_6();
		specialSecretTokenIngredientArray[1] = specialChar_1();
		specialSecretTokenIngredientArray[2] = specialChar_2();
		specialSecretTokenIngredientArray[3] = specialChar_2();
		specialSecretTokenIngredientArray[4] = specialChar_1();
		specialSecretTokenIngredientArray[5] = specialChar_3();
		specialSecretTokenIngredientArray[6] = specialChar_4();
		specialSecretTokenIngredientArray[7] = specialChar_5();
		specialSecretTokenIngredientArray[8] = specialChar_6();

		return new String(specialSecretTokenIngredientArray);
	}

	private static byte specialChar_1() {
		return 0b01000010;
	}

	private static byte specialChar_2() {
		return 0b01001111;
	}

	private static byte specialChar_3() {
		return 0b01001001;
	}

	private static byte specialChar_4() {
		return 0b01000101;
	}

	private static byte specialChar_5() {
		return 0b01010011;
	}

	private static byte specialChar_6() {
		return 0b00101101;
	}
}
