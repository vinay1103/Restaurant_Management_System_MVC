package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.OrdersDTO;
import com.restaurant.services.OrdersServiceImpl;
import com.restaurant.utils.ResponseUtil;

@RequestMapping("/orders")
@RestController
@CrossOrigin
public class OrdersControllerImpl {
@Autowired
private OrdersServiceImpl serviceImpl;




@GetMapping("find/{id}")
public ResponseEntity<?> getOrderById(@PathVariable("id") int id)
{
	return ResponseUtil.success(serviceImpl.findOrder(id));
	
}
@GetMapping("/{status}")
public ResponseEntity<?> getOrderByStatus(@PathVariable("status") String status)
{
	return ResponseUtil.success(serviceImpl.findOrderByStatus(status));
	
}

@PostMapping("")
public ResponseEntity<?> addOrder(@RequestBody OrdersDTO orderDTO)
{
	return ResponseUtil.success(serviceImpl.addOrder(orderDTO));
	
}

@PatchMapping("/{id}")
public ResponseEntity<?> updateCategory(@PathVariable("id") int id,@RequestBody OrdersDTO orderdto)
{
	return ResponseUtil.success(serviceImpl.updateOrderStatus(id,orderdto));
	
}

}
