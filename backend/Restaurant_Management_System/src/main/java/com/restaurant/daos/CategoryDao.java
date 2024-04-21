package com.restaurant.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Category;
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

	Category findByCategoryId(int id);
	List<Category> findByCategoryStatus(String status);
	
}
