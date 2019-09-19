package com.revature.model;

public class Admin {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	private String password;

	@Override
	public String toString() {
		return "Admin [email=" + email + ", name=" + name + ", password=" + password + "]";
	}

}
