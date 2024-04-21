package com.restaurant.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.daos.BillDao;
import com.restaurant.dtos.BillDTO;
import com.restaurant.dtos.BillDTOSend;
import com.restaurant.entities.Bill;
import com.restaurant.entities.Users;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class BillServiceImpl {

	@Autowired
	private BillDao billDao;
	@Autowired
	private DtoEntityConverter entityConverter;
	
	
	public BillDTOSend getBillById(int billId) {
		
	Bill bill=	billDao.findByBillId(billId);
	
	return entityConverter.toBillDTO(bill);
	}
	
	public List<BillDTOSend> findAllBill() {
		
	List<Bill> billList=	billDao.findAll();
	List<BillDTOSend> billDTOs= new ArrayList<BillDTOSend>();
	
	for (Bill bill :billList) {
		
		billDTOs.add(entityConverter.toBillDTO(bill));
	}
	return billDTOs;
	}
	
	
	public Map<String, Object> addBill(BillDTO billDTO) {
		// TODO Auto-generated method stub
		Bill bill=entityConverter.toBillEntity(billDTO);
		bill.setBillDate(Date.valueOf(java.time.LocalDate.now()));
		bill=	billDao.save(bill);
		return Collections.singletonMap("InsertedId", bill.getBillId());
	}

	public Map<String, Object> updateBill(int id,BillDTO billDTO) {
		// TODO Auto-generated method stub
		Bill bill= billDao.findByBillId(id);
		bill.setBillCashier(new Users(billDTO.getBillCashierId()));
		bill.setDiscount(billDTO.getDiscount());
		bill.setBillAmount(billDTO.getBillAmount());
		bill.setBillTotal(billDTO.getBillTotal());
		bill.setBillPaymentMethod(billDTO.getBillPaymentMethod());
		bill.setBillStatus(billDTO.getBillStatus());
		bill=billDao.save(bill);
		return Collections.singletonMap("UpdateId", bill.getBillId());
	}
	
	
	public int deleteBillById(int id) {
		// TODO Auto-generated method stub
		if(billDao.existsById(id))
		{
			billDao.deleteById(id);
			return 1;
		}
		
		return 0;
	}
	
	public Map<String, Float> getAmountData() {
		Map<String, Float> map = new HashMap<String, Float>();
		float today=0;
		float yesterday=0;
		float tw=0;
		float th=0;
		float fr=0;
		float fv=0;
		float sx=0;
	
		
		List<Bill> bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now()), "Completed");
		for (Bill bill : bills) {
			today+=bill.getBillAmount();
		}
		
		bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(1)), "Completed");
		for (Bill bill : bills) {
			yesterday+=bill.getBillAmount();
		}
	
		
		 bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(2)), "Completed");
		for (Bill bill : bills) {
			tw+=bill.getBillAmount();
		}
		
		bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(3)), "Completed");
		for (Bill bill : bills) {
			th+=bill.getBillAmount();
		}
		
		
		bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(4)), "Completed");
		for (Bill bill : bills) {
			fr+=bill.getBillAmount();
		}
	
		
		 bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(5)), "Completed");
		for (Bill bill : bills) {
			fv+=bill.getBillAmount();
		}
		
		bills= billDao.findByBillDateAndBillStatus(Date.valueOf(LocalDate.now().minusDays(6)), "Completed");
		for (Bill bill : bills) {
			sx+=bill.getBillAmount();
		}
		
		
		
		map.put("today", today);
		map.put("yesterday", yesterday);
		map.put("week", (today+yesterday+tw+th+fr+fv+sx));
		return map;
	}
	
}
