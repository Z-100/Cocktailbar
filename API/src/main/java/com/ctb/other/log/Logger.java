package com.ctb.other.log;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

	// 2021-03-24 16:48:05
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String log(String type, String message) {

		String current = sdf3.format(new Timestamp(System.currentTimeMillis()));

		System.out.println(String.format("%s\t-\t[%s]\t%s",
				current, type, message));

		return message;
	}
}
