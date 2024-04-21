package com.restaurant.utils;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

	public static ResponseEntity<?> success(Object data)
	{
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("status", "success");
		if(data!=null)
		{
			map.put("data", data);
		}
		
		return ResponseEntity.ok(map);
		
	}
	public static ResponseEntity<?> error(Object err)
	{
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("status", "error");
		if(err!=null)
		{
			map.put("error", err);
		}
		
		return ResponseEntity.ok(map);
		
	}
	
	public static ResponseEntity<?> status(HttpStatus status)
	{
		
		
		return ResponseEntity.status(status).build();
		
	}
}
