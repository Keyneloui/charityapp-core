package com.revature.util;

public class MessageConstant {
	
	//ConnectionUtil Messages
		public static final String DRIVER_CLASS = "Unable to load the driver class";
		
		public static final String SQL_CONNECTION = "Unable to get Connection";

		public static final String CLOSE_CONNECTION = "Unable to close the Connection";

		public static final String INVALID_LOGIN_CREDENTIALS = "Invalid Email/Password";
		
		//DAO Messages
		
		public static final String INVALID_CREDENTIALS="Invalid email/password";
		
		public static final String INVALID_INPUTS="Unable to update account ,password not found";
		
		public static final String ACCOUNT_EXISTS="Email,Name already exists\\nRegister with a new Email and Name";
		
		public static final String DONOR_LIST="Unable to view the donor list";
		

		public static final String DONOR_ACTIVITY="Unable to view the donor activity";
		// Donor class Messages

		public static final String DONOR_LIST_EMPTY = "No Donor Contributions yet";

		public static final String DONOR_TRANSACTION_EMPTY = "No transactions yet";

		public static final String USER_ALREADY_EXISTS = "User Already Exists,Register with a new email";


		// Fund Request messages

		public static final String FUND_REQUEST = "Unable to list fund";

		public static final String FUND_REQUEST_ADDITION = "Unable to add fund,category id Exists";

		public static final String FUND_REQUEST_ALTER = "Unable to alter fund";
		
		public static final String REQUEST_PROCESSING = "Unable to process your request";
		
		
		//Validator Exception Messages
		
		public static final String FUND_REQUEST_VALIDATOR="Give valid inputs";

}
