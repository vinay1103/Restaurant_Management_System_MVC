package com.restaurant.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.restaurant.daos.UserDao;
import com.restaurant.dtos.Credential;
import com.restaurant.dtos.UserDTO;
import com.restaurant.dtos.UserDTOSend;
import com.restaurant.entities.Users;
import com.restaurant.utils.DtoEntityConverter;


@Service
@Transactional
public class UserServiceImpl {

	
	@Autowired
	private UserDao usersDao;
	@Autowired
	private DtoEntityConverter entityConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Map<String, Object> addUser(UserDTO userDTO) {
		
		Users dbUser = usersDao.findByEmail(userDTO.getEmail());
		if(dbUser==null)
		{
			
		String encPassword = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encPassword);
		Users user=entityConverter.toUserEntity(userDTO);

		user.setDate(Date.valueOf(java.time.LocalDate.now()));
		user = usersDao.save(user);
		return Collections.singletonMap("insertedId", user.getUserId());
		}
		return null;
	}

	public List<UserDTOSend> getAllUser() {
		// TODO Auto-generated method stub
		List<Users> users = usersDao.findAll();
		List<UserDTOSend> userDTOs = new ArrayList<UserDTOSend>();
		
		for (Users user : users) {
			userDTOs.add(entityConverter.toUserDTO(user));
		}
		
		return userDTOs;
	}
	
	public List<UserDTOSend> getAllUserByStatus() {
		// TODO Auto-generated method stub
		List<Users> users = usersDao.findByCurrentStatus("Enabled");
		List<UserDTOSend> userDTOs = new ArrayList<UserDTOSend>();
		
		for (Users user : users) {
			userDTOs.add(entityConverter.toUserDTO(user));
		}
		
		return userDTOs;
	}
	public List<UserDTOSend> getAllWaiter(String role) {
		// TODO Auto-generated method stub
		List<Users> users = usersDao.findByRoleAndCurrentStatus(role,"Enabled");
		List<UserDTOSend> userDTOs = new ArrayList<UserDTOSend>();
		
		for (Users user : users) {
			userDTOs.add(entityConverter.toUserDTO(user));
		}
		
		return userDTOs;
	}
	public UserDTOSend getUserById(int id) {
		// TODO Auto-generated method stub
		Users user = usersDao.findByUserId(id);
		
		
		return entityConverter.toUserDTO(user);
	}

	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		if(usersDao.existsById(id))
		{
			Users user = usersDao.findByUserId(id);

			usersDao.deleteById(id);
			return 1;
		}
		
	return 0;
	}

	public Map<String, Object> updateUser(int id, UserDTO userdto) {
		
		// TODO Auto-generated method stub
		
		System.out.println("Pass: "+userdto.getPassword());
		if(userdto.getPassword()!=null)
		{
			String encPassword = passwordEncoder.encode(userdto.getPassword());
			userdto.setPassword(encPassword);
		}
		
		Users  users = usersDao.findByUserId(id);
		System.out.println();
		users.setName(userdto.getName());
		users.setEmail(userdto.getEmail());
		if(userdto.getPassword()!=null)
		users.setPassword(userdto.getPassword());
		users.setPhone(userdto.getPhone());
		if(userdto.getRole()!=null)
		users.setRole(userdto.getRole());
		
		users = usersDao.save(users);
		return Collections.singletonMap("UpdatedID", users.getUserId());
		
	}
	
	public Map<String, Object> updateUserStatus(int id, UserDTO userdto) {
		// TODO Auto-generated method stub
	
		Users  users = usersDao.findByUserId(id);
	
		
//		users.setProfileImage(profileImage);
		users.setCurrentStatus(userdto.getCurrentStatus());

		
		users = usersDao.save(users);
		return Collections.singletonMap("UpdatedID", users.getUserId());
		
	}
	
	public UserDTOSend findUserByEmailAndPassword(Credential cred) {
		Users dbUser = usersDao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbUser != null && passwordEncoder.matches(rawPassword, dbUser.getPassword())) {
			UserDTOSend result = entityConverter.toUserDTO(dbUser);

			return result;
		}
		return null;
	}
}
