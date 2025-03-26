package com.example.springboot.four;

import java.util.regex.Pattern;

public class EmailVer {
	private final Pattern EMAIL_REGEX = Pattern
			.compile("^[a-zA-Z0-9_+&*-]+(\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$");

	public boolean isValidEmail(String email) {
		return EMAIL_REGEX.matcher(email).matches();
	}
}
