package com.restaurant.dtos;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserDTOSend {

	private int userId;
	private String name;
	private String email;
	private String phone;
	private String profileImage;
	private String role;
	private String currentStatus="Enabled";
	private Date createdDate;
	
	public UserDTOSend() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTOSend(int userId, String name, String email, String phone, MultipartFile profileImage,
			String role, String currentStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
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


	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDTO [userId=%s, name=%s, email=%s, phone=%s, profileImage=%s, role=%s, currentStatus=%s]",
				userId, name, email, phone, profileImage, role, currentStatus);
	}
	
	
	
}
