package com.restaurant.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

	Orders findByOrderTable_TableIdAndOrderStatus(int id,String status);
	Orders findByOrderId(int id);
	
	List<Orders> findByOrderStatus(String status);
}
