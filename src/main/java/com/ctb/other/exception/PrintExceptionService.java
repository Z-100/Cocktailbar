package com.ctb.other.exception;

import java.util.Arrays;

public class PrintExceptionService {

	public static void print(String text, StackTraceElement[] message) {
		System.out.printf("%s\n%s%n", text, Arrays.toString(message));
	}
}
