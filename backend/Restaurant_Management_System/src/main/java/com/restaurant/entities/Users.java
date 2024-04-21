package com.restaurant.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
 * userId        | int          | NO   | PRI | NULL      | auto_increment    |
| name          | varchar(200) | YES  |     | NULL      |                   |
| email         | varchar(200) | YES  |     | NULL      |                   |
| phone         | varchar(50)  | YES  |     | NULL      |                   |
| password      | varchar(500) | YES  |     | NULL      |                   |
| profileImage  | blob         | YES  |     | NULL      |                   |
| role          | varchar(50)  | YES  |     | NULL      |                   |
| createdDate   | date         | YES  |     | curdate() | DEFAULT_GENERATED |
| currentStatus | varchar(50)  | YES  |     | NULL      |                   |
 */
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	//private String profileImage;
	private String role;
	private Date createdDate;
	private String currentStatus;
	@OneToMany(mappedBy = "waiter",cascade = CascadeType.REMOVE)
	private List<Tables> tableList;
	@OneToMany(mappedBy = "orderServicePerson",cascade = CascadeType.REMOVE)
	private List<Orders> ordersList;
	@OneToMany(mappedBy = "billCashier",cascade = CascadeType.REMOVE)
	private List<Bill> BillList;
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(int userId)
	{
		super();
		this.userId = userId;	
	}

	public Users(int userId, String name, String email, String phone, String password, String role,
			Date date, String currentStatus, List<Tables> tableList) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	//	this.profileImage = profileImage;
		this.role = role;
		this.createdDate = date;
		this.currentStatus = currentStatus;
		this.tableList = tableList;
	}


	public Users(int userId, String name, String email, String phone, String password,  String role,
			Date date, String currentStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		//this.profileImage = profileImage;
		this.role = role;
		this.createdDate = date;
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


//	public String getProfileImage() {
//		return profileImage;
//	}
//
//
//	public void setProfileImage(String profileImage) {
//		this.profileImage = profileImage;
//	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Date getDate() {
		return createdDate;
	}


	public void setDate(Date date) {
		this.createdDate = date;
	}


	public String getCurrentStatus() {
		return currentStatus;
	}


	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}


	public List<Tables> getTableList() {
		return tableList;
	}


	public void setTableList(List<Tables> tableList) {
		this.tableList = tableList;
	}


	@Override
	public String toString() {
		return String.format(
				"Users [userId=%s, name=%s, email=%s, phone=%s, password=%s, role=%s, date=%s, currentStatus=%s]",
				userId, name, email, phone, password, role, createdDate, currentStatus);
	}
	
	
	
}
