package com.restaurant.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private float taxAndCharge;
	private float discount;
	private float billAmount;
	private float billTotal;
	private Date billDate;
	private String billPaymentMethod;
	private String billStatus;
	@OneToOne
	@JoinColumn(name = "billOrderId")
	private Orders billOrder;
	@ManyToOne
	@JoinColumn(name = "billCashierId")
	private Users billCashier;
	
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(int billId, float taxAndCharge, float discount, float billAmount, Date billDate,
			String billPaymentMethod, String billStatus, Orders billOrder, Users billCashier) {
		super();
		this.billId = billId;
		this.taxAndCharge = taxAndCharge;
		this.discount = discount;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.billPaymentMethod = billPaymentMethod;
		this.billStatus = billStatus;
		this.billOrder = billOrder;
		this.billCashier = billCashier;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
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

	public Orders getBillOrder() {
		return billOrder;
	}

	public void setBillOrder(Orders billOrder) {
		this.billOrder = billOrder;
	}

	public Users getBillCashier() {
		return billCashier;
	}

	public void setBillCashier(Users billCashier) {
		this.billCashier = billCashier;
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
				"Bill [billId=%s, taxAndCharge=%s, discount=%s, billAmount=%s, billDate=%s, billPaymentMethod=%s, billStatus=%s, billOrder=%s, billCashier=%s]",
				billId, taxAndCharge, discount, billAmount, billDate, billPaymentMethod, billStatus, billOrder,
				billCashier);
	}
	
	
	
	
}
