package com.revature.validator;

import com.revature.exception.ValidatorException;
import com.revature.model.User;

public class UserValidator {
	public void validateBeforeRegistration(User user) throws ValidatorException {

		rejectIfInvalidString(user.getName(), "Invalid Name");

		rejectIfInvalidString(user.getEmail(), "Invalid email");

		rejectIfInvalidString(user.getPassword(), "Invalid Password");

	}

	public void rejectIfInvalidString(String input, String message) throws ValidatorException {
		if (isInvalidString(input)) {
			throw new ValidatorException(message);
		}
	}

	public void rejectIfInvalidNumber(int input, String message) throws ValidatorException {
		if (isInvalidNumber(input)) {
			throw new ValidatorException(message);
		}

	}

	private boolean isInvalidNumber(int input) {
		return input == 0;
	}

	private boolean isInvalidString(String name) {
		String values = "(.[0-9].)";

		String specialCharacters = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].$)";

		return name == null || name.matches(values) || name.matches(specialCharacters) || "".equals(name.trim());

	}
}
