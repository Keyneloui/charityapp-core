package com.revature.model;

public class Admin {
	private String email;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "Admin [email=" + email + ", id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
