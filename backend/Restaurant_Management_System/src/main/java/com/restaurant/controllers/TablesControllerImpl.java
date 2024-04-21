package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dtos.TablesDTO;
import com.restaurant.services.TableServiceImpl;
import com.restaurant.utils.ResponseUtil;
@RequestMapping("/tables")
@RestController
@CrossOrigin
public class TablesControllerImpl {
	
	@Autowired 
	private TableServiceImpl tservice;
	
	
	@GetMapping("")
	public ResponseEntity<?> getAllTables()
	{
		return ResponseUtil.success(tservice.getAllTables());
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getAllTablesByStatus()
	{
		return ResponseUtil.success(tservice.getAllTablesByStatus());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTablesByWaiterId(@PathVariable("id") int id)
	{
		return ResponseUtil.success(tservice.getTablesByWaiter(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> addTable(@RequestBody TablesDTO tablesDTO)
	{
		
		return ResponseUtil.success(tservice.addTable(tablesDTO));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTable(@PathVariable("id") int id,@RequestBody TablesDTO tablesDTO)
	{
		
		return ResponseUtil.success(tservice.updateTable(id,tablesDTO));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTable(@PathVariable("id") int id)
	{
		
		return ResponseUtil.success(tservice.deleteTableById(id));
	}
	
	@PutMapping("/assign/{id}")
	public ResponseEntity<?> assignWaiter(@PathVariable("id") int id,@RequestBody TablesDTO tablesDTO)
	{
		
		return ResponseUtil.success(tservice.assignTableWaiter(id,tablesDTO));
	}
}
