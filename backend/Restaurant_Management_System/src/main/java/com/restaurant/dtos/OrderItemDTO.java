package com.restaurant.dtos;
/*
 *  orderItemOrderId | orderItemProductId | orderItemQuantity
 */
public class OrderItemDTO {
private int orderItemId;	
private int orderItemOrderId;
private int orderItemProductId;
private int orderItemQuantity;
private float orderItemRate=0.0f;
private float orderItemAmount=0.0f;
private String orderItemName;
public OrderItemDTO() {
	// TODO Auto-generated constructor stub
}



public OrderItemDTO(int orderItemOrderId, int orderItemProductId, int orderItemQuantity, float orderItemRate) {
	super();
	this.orderItemOrderId = orderItemOrderId;
	this.orderItemProductId = orderItemProductId;
	this.orderItemQuantity = orderItemQuantity;
	this.orderItemRate = orderItemRate;
}



public int getOrderItemId() {
	return orderItemId;
}



public void setOrderItemId(int orderItemId) {
	this.orderItemId = orderItemId;
}



public int getOrderItemOrderId() {
	return orderItemOrderId;
}

public void setOrderItemOrderId(int orderItemOrderId) {
	this.orderItemOrderId = orderItemOrderId;
}

public int getOrderItemProductId() {
	return orderItemProductId;
}

public void setOrderItemProductId(int orderItemProductId) {
	this.orderItemProductId = orderItemProductId;
}

public int getOrderItemQuantity() {
	return orderItemQuantity;
}

public void setOrderItemQuantity(int orderItemQuantity) {
	this.orderItemQuantity = orderItemQuantity;
}


public float getOrderItemRate() {
	return orderItemRate;
}

public void setOrderItemRate(float orderItemRate) {
	this.orderItemRate = orderItemRate;
}



public float getOrderItemAmount() {
	return orderItemAmount;
}



public void setOrderItemAmount(float orderItemAmount) {
	this.orderItemAmount = orderItemAmount;
}



public String getOrderItemName() {
	return orderItemName;
}



public void setOrderItemName(String orderItemName) {
	this.orderItemName = orderItemName;
}



@Override
public String toString() {
	return "OrderItemDTO [orderItemId=" + orderItemId + ", orderItemOrderId=" + orderItemOrderId
			+ ", orderItemProductId=" + orderItemProductId + ", orderItemQuantity=" + orderItemQuantity
			+ ", orderItemRate=" + orderItemRate + ", orderItemAmount=" + orderItemAmount + ", orderItemName="
			+ orderItemName + "]";
}


















}
