package com.restaurant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.daos.OrderItemDao;
import com.restaurant.daos.ProductDao;
import com.restaurant.dtos.OrderItemDTO;
import com.restaurant.entities.OrderItem;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class OrderItemServiceImpl {

	@Autowired
	private OrderItemDao ordersItemDao;
	@Autowired
	private ProductDao pDao;
	@Autowired
	private DtoEntityConverter entityConverter;
	
	// ITERATOR PATTERN
	public List<OrderItemDTO> findOrderItemByOrder(int orderId) {
		
	List<OrderItem> orderItems=	ordersItemDao.findByOrderItemOrder_OrderId(orderId);
	List<OrderItemDTO> itemDTOs= new ArrayList<OrderItemDTO>();
	
	for (OrderItem orderItem :orderItems ) {
		
		itemDTOs.add(entityConverter.toOrderItemDTO(orderItem));
	}
	return itemDTOs;
	}
	
	public Map<String, Object> addOrderItem(OrderItemDTO orderItemDTO) {
		// TODO Auto-generated method stub
		OrderItem orderItem = entityConverter.toOrderItemEntity(orderItemDTO);
		float price= pDao.findByProductId(orderItemDTO.getOrderItemProductId()).getProductPrice();
		orderItem.setOrderItemAmount(price*(float)orderItemDTO.getOrderItemQuantity());
		orderItem=	ordersItemDao.save(orderItem);
		
		
		return Collections.singletonMap("InsertedId", orderItem.getOrderItemId());
	}

	public Map<String, Object> updateOrderItem(int id, OrderItemDTO orderItemDTO) {
		// TODO Auto-generated method stub
		//System.out.println(orderItemDTO.getOrderItemQuantity());
		OrderItem item=	ordersItemDao.findByOrderItemId(id);
		if(orderItemDTO.getOrderItemQuantity()!=0)
		{
		
		item.setOrderItemQuantity(orderItemDTO.getOrderItemQuantity());
		float price=pDao.findByProductId(item.getOrderItemProduct().getProductId()).getProductPrice();
		item.setOrderItemAmount(price*(float)orderItemDTO.getOrderItemQuantity());
		item=ordersItemDao.save(item);
		
		
		
		}
		
		
		return Collections.singletonMap("UpdatedId", item.getOrderItemId());
	}

	public int deleteItemByItemId(int id) {
		// TODO Auto-generated method stub
		if(ordersItemDao.existsById(id))
		{
			ordersItemDao.deleteById(id);
			return 1;
		}
		
		return 0;
	}


}
