package com.restaurant.dtos;

public class Credential {

	private String email;
	private String password;
	
	public Credential() {
		// TODO Auto-generated constructor stub
	}

	public Credential(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return String.format("Credential [email=%s, password=%s]", email, password);
	}
	
	
}
