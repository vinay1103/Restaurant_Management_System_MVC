package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.OrderItemDTO;
import com.restaurant.services.OrderItemServiceImpl;
import com.restaurant.utils.ResponseUtil;

@RequestMapping("/item")
@RestController
@CrossOrigin
public class OrderItemControllerImpl {
@Autowired
private OrderItemServiceImpl itemServiceImpl;




@GetMapping("/{id}")
public ResponseEntity<?> getItemByOrderId(@PathVariable("id") int id)
{
	return ResponseUtil.success(itemServiceImpl.findOrderItemByOrder(id));
	
}


@PostMapping("")
public ResponseEntity<?> addOrder(@RequestBody OrderItemDTO orderItemDTO)
{
	return ResponseUtil.success(itemServiceImpl.addOrderItem(orderItemDTO));
	
}

@PatchMapping("/{id}")
public ResponseEntity<?> updateCategory(@PathVariable("id") int id,@RequestBody OrderItemDTO orderItemDTO)
{
	return ResponseUtil.success(itemServiceImpl.updateOrderItem(id,orderItemDTO));
	
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteItemById(@PathVariable("id") int id)
{
	return ResponseUtil.success(itemServiceImpl.deleteItemByItemId(id));
	
}

}
