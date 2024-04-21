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
import javax.persistence.Table;


/*
 *  tableId       | int         | NO   | PRI | NULL    | auto_increment |
| tableName     | varchar(50) | YES  |     | NULL    |                |
| tableCapacity | int         | YES  |     | NULL    |                |
| waiterId      | int         | YES  | MUL | NULL    |                |
| tableStatus   | varchar(50)
 */
@Entity
@Table(name = "tables")
public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableId;
	private String tableName;
	private int tableCapacity;
	@ManyToOne
	@JoinColumn(name = "waiterId")
	private Users waiter;
	@OneToMany(mappedBy = "orderTable",cascade = CascadeType.REMOVE)
	List<Orders> ordersList;
	private String tableStatus;
	
	
	public Tables() {
		// TODO Auto-generated constructor stub
	}


	public Tables(int tableId) {
		super();
		this.tableId = tableId;
	}


	public Tables(int tableId, String tableName, int tableCapacity, Users waiter, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.waiter = waiter;
		this.tableStatus = tableStatus;
	}


	public Tables(int tableId, String tableName, int tableCapacity, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.tableStatus = tableStatus;
	}


	public int getTableId() {
		return tableId;
	}


	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public int getTableCapacity() {
		return tableCapacity;
	}


	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}


	public Users getWaiter() {
		return waiter;
	}


	public void setWaiter(Users waiter) {
		this.waiter = waiter;
	}


	public String getTableStatus() {
		return tableStatus;
	}


	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}


	@Override
	public String toString() {
		return String.format("Tables [tableId=%s, tableName=%s, tableCapacity=%s, waiter=%s, tableStatus=%s]", tableId,
				tableName, tableCapacity, waiter, tableStatus);
	}
	
	
	
	
	
	
}
