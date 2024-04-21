package com.restaurant.dtos;

import java.sql.Date;
/*
 * | billId            | int          | NO   | PRI | NULL      | auto_increment    |
| billOrderId       | int          | YES  | MUL | NULL      |                   |
| billCashierId     | int          | YES  | MUL | NULL      |                   |
| taxAndCharge      | decimal(4,2) | YES  |     | 5.00      |                   |
| discount          | decimal(4,2) | YES  |     | NULL      |                   |
| billAmount        | decimal(8,2) | YES  |     | NULL      |                   |
| billDate          | date         | YES  |     | curdate() | DEFAULT_GENERATED |
| billPaymentMethod | varchar(50)  | YES  |     | NULL      |                   |
| billStatus        | varchar(50)  | YES  |     | NULL      |
 */

public class BillDTOSend {
	
	private int billId;
	private int billOrderId;
	private String billCashierName;
	private String waiterName;
	private float taxAndCharge;
	private float discount;
	private float billAmount;
	private float billTotal;
	private Date billDate;
	private String billPaymentMethod;
	private String billStatus;
	private String tableName;
	private int tableId;

	
	public BillDTOSend() {
		// TODO Auto-generated constructor stub
	}


	public BillDTOSend(int billOrderId, String billCashierName, String waiterName, float taxAndCharge, float discount,
			float billAmount, Date billDate, String billPaymentMethod, String billStatus, String tableName) {
		super();
		this.billOrderId = billOrderId;
		this.billCashierName = billCashierName;
		this.waiterName = waiterName;
		this.taxAndCharge = taxAndCharge;
		this.discount = discount;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.billPaymentMethod = billPaymentMethod;
		this.billStatus = billStatus;
		this.tableName = tableName;
	}


	public int getBillOrderId() {
		return billOrderId;
	}


	public void setBillOrderId(int billOrderId) {
		this.billOrderId = billOrderId;
	}


	public String getBillCashierName() {
		return billCashierName;
	}


	public void setBillCashierName(String billCashierName) {
		this.billCashierName = billCashierName;
	}


	public String getWaiterName() {
		return waiterName;
	}


	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}


	public float getTaxAndCharge() {
		return taxAndCharge;
	}


	public void setTaxAndCharge(float taxAndCharge) {
		this.taxAndCharge = taxAndCharge;
	}


	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public float getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}


	public Date getBillDate() {
		return billDate;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public String getBillPaymentMethod() {
		return billPaymentMethod;
	}


	public void setBillPaymentMethod(String billPaymentMethod) {
		this.billPaymentMethod = billPaymentMethod;
	}


	public String getBillStatus() {
		return billStatus;
	}


	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public int getTableId() {
		return tableId;
	}


	public void setTableId(int tableId) {
		this.tableId = tableId;
	}


	public float getBillTotal() {
		return billTotal;
	}


	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}


	@Override
	public String toString() {
		return String.format(
				"BillDTOSend [billId=%s,billOrderId=%s, billCashierName=%s, waiterName=%s, taxAndCharge=%s, discount=%s, billAmount=%s, billDate=%s, billPaymentMethod=%s, billStatus=%s, tableName=%s]",
				billId,billOrderId, billCashierName, waiterName, taxAndCharge, discount, billAmount, billDate,
				billPaymentMethod, billStatus, tableName);
	}


	




	
	
	
	
}
