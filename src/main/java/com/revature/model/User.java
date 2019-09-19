package com.revature.model;

public class User {

	private String name;
	private String email;
	private String password;

	@Override
	public String toString() {
		return " Name=" + name + ", Email=" + email + ", Password=" + password + ".";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
