package com.restaurant.daos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Bill;
@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {
	Bill findByBillId(int id);
	List<Bill> findByBillDateAndBillStatus(Date date,String status );

	
	
}
