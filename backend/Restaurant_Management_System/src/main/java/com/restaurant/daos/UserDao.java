package com.restaurant.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Users;
@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

	Users findByUserId(int id);
	List<Users> findByRoleAndCurrentStatus(String role,String status);
	List<Users> findByCurrentStatus(String status);
	Users findByEmail(String email);
}
