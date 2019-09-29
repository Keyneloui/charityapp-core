package com.revature.validator;

import com.revature.exception.ValidatorException;
import com.revature.model.User;

public class UserValidator {
	public void validateBeforeRegistration(User user) throws ValidatorException {

		rejectIfInvalidString(user.getName(), "Invalid Name");


		rejectIfInvalidPassword(user.getPassword());

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

	private boolean isInvalidString(String input) {
		String values = "(.[0-9].[A-Z].)";

		String specialCharacters = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].$)";

		return input == null || input.matches(values) || input.matches(specialCharacters) || "".equals(input.trim());

	}
	public void rejectIfInvalidPassword(String input) throws ValidatorException {
	{
	      
	   if (input.length() > 15 || input.length() < 8)
	   {
	           throw new ValidatorException("Password should be less than 15 and more than 8 characters in length.");
	   }
	   String upperCaseChars = "(.[A-Z].)";
	   if (!input.matches(upperCaseChars ))
	   {
	           throw new ValidatorException("Password should contain atleast one upper case alphabet");
	   }
	   String lowerCaseChars = "(.[a-z].)";
	   if (!input.matches(lowerCaseChars ))
	   {
	           throw new ValidatorException("Password should contain atleast one lower case alphabet");
	   }
	   String numbers = "(.[0-9].)";
	   if (!input.matches(numbers ))
	   {
	           throw new ValidatorException("Password should contain atleast one number.");
	   }
	   String specialChars = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].$)";
	   if (!input.matches(specialChars ))
	   {
	           throw new ValidatorException("Password should contain atleast one special character");
	   }
	}
}
}
