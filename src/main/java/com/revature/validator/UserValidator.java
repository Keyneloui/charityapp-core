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

	private boolean isInvalidString(String name) throws ValidatorException {
		 String values = "(.[0-9].)";
	        if (name.matches(values ))
	        {
	                throw new ValidatorException("Name should not contains numeric values");
	        }
	        String specialCharacters = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].$)";
	        if (name.matches(specialCharacters ))
	        {
	                throw new ValidatorException("Name should not contains special character");
	        }
		return name == null || "".equals(name.trim());
		
	    }
	}

