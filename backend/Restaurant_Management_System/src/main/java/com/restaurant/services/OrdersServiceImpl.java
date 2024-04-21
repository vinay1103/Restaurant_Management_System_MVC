package com.restaurant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.daos.OrdersDao;
import com.restaurant.dtos.OrdersDTO;
import com.restaurant.entities.Orders;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class OrdersServiceImpl {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private DtoEntityConverter entityConverter;
	
	
	public OrdersDTO findOrder(int tableId) {
		
	Orders orders=	ordersDao.findByOrderTable_TableIdAndOrderStatus(tableId, "Pending");
	
	return entityConverter.toOrderDTO(orders);
	}
	
	public List<OrdersDTO> findOrderByStatus(String status) {
		
	List<Orders> orderList=	ordersDao.findByOrderStatus(status);
	List<OrdersDTO> ordersDTOs= new ArrayList<OrdersDTO>();
	
	for (Orders order :orderList ) {
		
		ordersDTOs.add(entityConverter.toOrderDTO(order));
	}
	return ordersDTOs;
	}
	
	public Map<String, Object> addOrder(OrdersDTO orderDTO) {
		// TODO Auto-generated method stub
		Orders orders = ordersDao.save(entityConverter.toOrderEntity(orderDTO));
		return Collections.singletonMap("orderId", orders.getOrderId());
	}

	public Map<String, Object> updateOrderStatus(int id,OrdersDTO orderdto) {
		// TODO Auto-generated method stub
		Orders orders = ordersDao.findByOrderId(id);
		orders.setOrderStatus(orderdto.getOrderStatus());
		orders = ordersDao.save(orders);
		return Collections.singletonMap("orderId", orders.getOrderId());
	}
}
