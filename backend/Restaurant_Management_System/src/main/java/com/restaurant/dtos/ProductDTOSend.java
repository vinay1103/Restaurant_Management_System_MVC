package com.restaurant.dtos;

public class ProductDTOSend {
	private int productId;
	private String productName;
	private float productPrice;
	private String productStatus;
	private int productcategoryId;
	private String productcategoryName;
	public ProductDTOSend() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTOSend(int productId, String productName, float productPrice, 
			String productStatus, int productcategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStatus = productStatus;
		this.productcategoryId = productcategoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getProductcategoryId() {
		return productcategoryId;
	}

	public void setProductcategoryId(int productcategoryId) {
		this.productcategoryId = productcategoryId;
	}

	
	
	public String getProductcategoryName() {
		return productcategoryName;
	}

	public void setProductcategoryName(String productcategoryName) {
		this.productcategoryName = productcategoryName;
	}

	@Override
	public String toString() {
		return "ProductDTOSend [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productStatus=" + productStatus + ", productcategoryId=" + productcategoryId
				+ ", productcategoryName=" + productcategoryName + "]";
	}


	
	
	
}
