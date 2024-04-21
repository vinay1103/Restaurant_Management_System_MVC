package com.restaurant.dtos;

public class CategoryDTO {
	private int  categoryId;
	private String categoryName;		
	private String categoryStatus="Enabled";
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(int categoryId, String categoryName, String categoryStatus) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	@Override
	public String toString() {
		return String.format("CategoryDTO [categoryId=%s, categoryName=%s, categoryStatus=%s]", categoryId,
				categoryName, categoryStatus);
	}
	
	
	
}
