package com.restaurant.dtos;

public class  UserDTO {

	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	//private MultipartFile profileImage;
	private String role;
	private String currentStatus="Enabled";
	
	public  UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int userId, String name, String email, String phone, String password,
			String role, String currentStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
//		this.profileImage = profileImage;
		this.role = role;
		this.currentStatus = currentStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public MultipartFile getProfileImage() {
//		return profileImage;
//	}
//
//	public void setProfileImage(MultipartFile profileImage) {
//		this.profileImage = profileImage;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDTO [userId=%s, name=%s, email=%s, phone=%s, password=%s, profileImage=%s, role=%s, currentStatus=%s]",
				userId, name, email, phone, password, role, currentStatus);
	}
	
	
	
}
