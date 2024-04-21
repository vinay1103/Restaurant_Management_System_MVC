package com.restaurant.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * orderId              | int         | NO   | PRI | NULL    | auto_increment |
| orderServicePersonId | int         | YES  | MUL | NULL    |                |
| orderTableId         | int         | YES  | MUL | NULL    |                |
| orderType            | varchar(50) | YES  |     | NULL    |                |
| orderStatus          | varchar(50) | YES  |     | NULL    |
 */
@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderStatus;
	@ManyToOne
	@JoinColumn(name = "orderServicePersonId")
	private Users orderServicePerson;
	@ManyToOne
	@JoinColumn(name = "orderTableId")
	private Tables orderTable;
	
	@OneToMany(mappedBy = "orderItemOrder",cascade = CascadeType.REMOVE)
	private List<OrderItem> ordersItemList;
	
	@OneToOne(mappedBy = "billOrder",cascade = CascadeType.REMOVE)
	private Bill OrderBill;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Orders(int orderId) {
		super();
		this.orderId = orderId;
	}


	public Orders(int orderId,  String orderStatus, Users orderServicePerson, Tables orderTable) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderServicePerson = orderServicePerson;
		this.orderTable = orderTable;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Users getOrderServicePerson() {
		return orderServicePerson;
	}
	public void setOrderServicePerson(Users orderServicePerson) {
		this.orderServicePerson = orderServicePerson;
	}
	public Tables getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(Tables orderTable) {
		this.orderTable = orderTable;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderServicePerson="
				+ orderServicePerson + ", orderTable=" + orderTable + ", ordersItemList=" + ordersItemList
				+ ", OrderBill=" + OrderBill + "]";
	}

	
	
	
	
}
