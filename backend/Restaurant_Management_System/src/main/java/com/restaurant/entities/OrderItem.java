package com.restaurant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * orderItemId        | int          | NO   | PRI | NULL    | auto_increment |
| orderItemOrderId   | int          | YES  | MUL | NULL    |                |
| orderItemProductId | int          | YES  | MUL | NULL    |                |
| orderItemQuantity  | int          | YES  |     | NULL    |                |
| orderItemAmount    | decimal(8,2) | YES  |     | NULL    |                |
| orderItemStatus    | varchar(50)  | YES  |     | NULL    |
 */
@Entity
@Table(name = "orderitem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	private int orderItemQuantity;
	private float orderItemAmount;
	@ManyToOne
	@JoinColumn(name = "orderItemOrderId")
	private Orders orderItemOrder;
	@ManyToOne
	@JoinColumn(name = "orderItemProductId")
	private Product orderItemProduct;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int orderItemId, int orderItemQuantity, float orderItemAmount,
			Orders orderItemOrder, Product orderItemProduct) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemAmount = orderItemAmount;
		this.orderItemOrder = orderItemOrder;
		this.orderItemProduct = orderItemProduct;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public float getOrderItemAmount() {
		return orderItemAmount;
	}

	public void setOrderItemAmount(float orderItemAmount) {
		this.orderItemAmount = orderItemAmount;
	}
	public Orders getOrderItemOrder() {
		return orderItemOrder;
	}

	public void setOrderItemOrder(Orders orderItemOrder) {
		this.orderItemOrder = orderItemOrder;
	}

	public Product getOrderItemProduct() {
		return orderItemProduct;
	}

	public void setOrderItemProduct(Product orderItemProduct) {
		this.orderItemProduct = orderItemProduct;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemQuantity=" + orderItemQuantity
				+ ", orderItemAmount=" + orderItemAmount + ", orderItemOrder=" + orderItemOrder + ", orderItemProduct="
				+ orderItemProduct + "]";
	}

	
	
	
}
