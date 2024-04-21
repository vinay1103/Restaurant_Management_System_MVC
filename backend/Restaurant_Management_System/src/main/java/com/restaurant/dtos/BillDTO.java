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

public class BillDTO {

	private int billOrderId;
	private int billCashierId;
	private float taxAndCharge=5.0f;
	private float discount;
	private float billAmount;
	private float billTotal;
	private Date billDate;
	private String billPaymentMethod;
	private String billStatus="InProcess";

	
	public BillDTO() {
		// TODO Auto-generated constructor stub
	}


	public BillDTO(int billOrderId, int billCashierId, float taxAndCharge, float discount, float billAmount,
			Date billDate, String billPaymentMethod, String billStatus) {
		super();
		this.billOrderId = billOrderId;
		this.billCashierId = billCashierId;
		this.taxAndCharge = taxAndCharge;
		this.discount = discount;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.billPaymentMethod = billPaymentMethod;
		this.billStatus = billStatus;
	}


	public int getBillOrderId() {
		return billOrderId;
	}


	public void setBillOrderId(int billOrderId) {
		this.billOrderId = billOrderId;
	}


	public int getBillCashierId() {
		return billCashierId;
	}


	public void setBillCashierId(int billCashierId) {
		this.billCashierId = billCashierId;
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

	

	public float getBillTotal() {
		return billTotal;
	}


	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}


	@Override
	public String toString() {
		return String.format(
				"BillDTO [billOrderId=%s, billCashierId=%s, taxAndCharge=%s, discount=%s, billAmount=%s, billDate=%s, billPaymentMethod=%s, billStatus=%s]",
				billOrderId, billCashierId, taxAndCharge, discount, billAmount, billDate, billPaymentMethod,
				billStatus);
	}




	
	
	
	
}
