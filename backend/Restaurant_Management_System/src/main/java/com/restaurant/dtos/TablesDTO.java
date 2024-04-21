package com.restaurant.dtos;

public class TablesDTO {
	
	private int tableId;
	private String tableName;
	private int tableCapacity;
	private int waiterId;
	private String waiterName;
	private String tableStatus="Not Booked";
	
	public TablesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public TablesDTO(int tableId, String tableName, int tableCapacity, int waiterId, String tableStatus) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
		this.waiterId = waiterId;
		this.tableStatus = tableStatus;
	}



	public TablesDTO(String tableName, int tableCapacity) {
		super();
		this.tableName = tableName;
		this.tableCapacity = tableCapacity;
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



	public int getTableId() {
		return tableId;
	}



	public void setTableId(int tableId) {
		this.tableId = tableId;
	}



	public int getWaiterId() {
		return waiterId;
	}



	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}



	public String getTableStatus() {
		return tableStatus;
	}



	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}



	public String getWaiterName() {
		return waiterName;
	}



	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}



	@Override
	public String toString() {
		return String.format("TablesDTO [tableId=%s, tableName=%s, tableCapacity=%s, waiterId=%s, tableStatus=%s]",
				tableId, tableName, tableCapacity, waiterId, tableStatus);
	}
	
	
	
}
