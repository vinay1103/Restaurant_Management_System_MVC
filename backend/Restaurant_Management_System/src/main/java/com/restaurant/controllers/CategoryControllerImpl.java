package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.CategoryDTO;
import com.restaurant.services.CategoryServiceImpl;
import com.restaurant.utils.ResponseUtil;

@RequestMapping("/categories")
@RestController
@CrossOrigin
public class CategoryControllerImpl {
@Autowired
private CategoryServiceImpl serviceImpl;


@GetMapping("")
public ResponseEntity<?> getAllCategories()
{
	
	return ResponseUtil.success(serviceImpl.getAllCategories());
}

@GetMapping("/{id}")
public ResponseEntity<?> getCategoryById(@PathVariable("id") int id)
{
	return ResponseUtil.success(serviceImpl.getCategoryById(id));
	
}
@GetMapping("/active")
public ResponseEntity<?> getCategoryByStatus()
{
	return ResponseUtil.success(serviceImpl.getAllCategoriesByStatus());
	
}
@PostMapping("")
public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categorydto)
{
	return ResponseUtil.success(serviceImpl.addCategory(categorydto));
	
}

@PutMapping("/{id}")
public ResponseEntity<?> updateCategory(@PathVariable("id") int id,@RequestBody CategoryDTO categorydto)
{
	return ResponseUtil.success(serviceImpl.updateCategory(id,categorydto));
	
}

@PatchMapping("/{id}")
public ResponseEntity<?> updateCategoryStatus(@PathVariable("id") int id,@RequestBody CategoryDTO categorydto)
{
	return ResponseUtil.success(serviceImpl.updateCategoryStatus(id,categorydto));
	
}


@DeleteMapping("/{id}")
public ResponseEntity<?> deleteCategoryById(@PathVariable("id") int id)
{
	return ResponseUtil.success(serviceImpl.deleteCategoryById(id));
	
}
}
