package com.restaurant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.restaurant.daos.CategoryDao;
import com.restaurant.dtos.CategoryDTO;
import com.restaurant.entities.Category;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class CategoryServiceImpl {
	@Autowired
	private CategoryDao catDao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	
	
	public List<CategoryDTO> getAllCategories()
	{
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		List<Category> catList=	catDao.findAll();
		for (Category category : catList) {
			list.add(converter.toCategoryDTO(category));
		}
		
		return list;
	}
	
	public List<CategoryDTO> getAllCategoriesByStatus()
	{
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		List<Category> catList=	catDao.findByCategoryStatus("Enabled");
		for (Category category : catList) {
			list.add(converter.toCategoryDTO(category));
		}
		
		return list;
	}
	public CategoryDTO getCategoryById(int id)
	{
		Category category = catDao.findByCategoryId(id);
		return converter.toCategoryDTO(category);
	}
	
	public Map<String, Object> addCategory(CategoryDTO categoryDto)
	{
	Category category=	catDao.save(converter.toCategoryEntity(categoryDto));
		return  Collections.singletonMap("insertedId", category.getCategoryId());
	}
	
	
	public  Map<String, Object> updateCategory(int id,CategoryDTO categoryDto)
	{
		Category category = catDao.findByCategoryId(id);
		category.setCategoryName(categoryDto.getCategoryName());
		category=	catDao.save(category);
		return  Collections.singletonMap("UpdatedId",category.getCategoryId());
	}
	
	public  Map<String, Object> updateCategoryStatus(int id,CategoryDTO categoryDto)
	{
		System.out.println(categoryDto);
		Category category = catDao.findByCategoryId(id);
		category.setCategoryStatus(categoryDto.getCategoryStatus());
		category=	catDao.save(category);
		return  Collections.singletonMap("UpdatedId",category.getCategoryId());
	}
	
	public int deleteCategoryById(int id)
	{
		if(catDao.existsById(id))
		{
			catDao.deleteById(id);
			return 1;
		}
		
		return 0;
	}
}
