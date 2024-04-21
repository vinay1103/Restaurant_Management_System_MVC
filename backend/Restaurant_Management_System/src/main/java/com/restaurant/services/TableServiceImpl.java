package com.restaurant.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.daos.TablesDao;
import com.restaurant.daos.UserDao;
import com.restaurant.dtos.TablesDTO;
import com.restaurant.entities.Tables;
import com.restaurant.entities.Users;
import com.restaurant.utils.DtoEntityConverter;

@Service
@Transactional
public class TableServiceImpl {

	
	@Autowired
	private TablesDao tablesDao;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DtoEntityConverter entityConverter;
	
	public List<TablesDTO> getAllTables()
	{
	List<TablesDTO> dtos = new ArrayList<TablesDTO>();
	List<Tables> tables = tablesDao.findAll();
	
	for (Tables table : tables) {
		
		dtos.add(entityConverter.toTablesDTO(table));
	}
	
	return dtos;
	}

	//
	public List<TablesDTO> getAllTablesByStatus()
	{
	List<TablesDTO> dtos = new ArrayList<TablesDTO>();
	List<Tables> tables = tablesDao.findByTableStatus("Booked");
	
	for (Tables table : tables) {
		
		dtos.add(entityConverter.toTablesDTO(table));
	}
	
	return dtos;
	}
	public Map<String, Object> addTable(TablesDTO tablesDTO) {
		// TODO Auto-generated method stub
		Tables tables = tablesDao.save(entityConverter.toTablesEntity(tablesDTO));
		return Collections.singletonMap("InsertedId", tables.getTableId());
	}

	public int deleteTableById(int id) {
		// TODO Auto-generated method stub
		if(tablesDao.existsById(id))
		{
			tablesDao.deleteById(id);
			return 1;
		}
		
		return 0;
	}

	public Map<String, Object> assignTableWaiter(int id, TablesDTO tablesDTO) {
		// TODO Auto-generated method stub
		
		Tables tables = tablesDao.findByTableId(id);
		tables.setTableStatus(tablesDTO.getTableStatus());
		tables.setWaiter(userDao.findByUserId(tablesDTO.getWaiterId()));
		tables=	tablesDao.save(tables);
		return Collections.singletonMap("UpdatedId", tables.getTableId());
	}
	
	public List<TablesDTO> getTablesByWaiter(int id)
	{
	List<TablesDTO> dtos = new ArrayList<TablesDTO>();
	List<Tables> tables = tablesDao.findByWaiter_UserId(id);
	
	for (Tables table : tables) {
		
		dtos.add(entityConverter.toTablesDTO(table));
	}
	
	return dtos;
	}

	public  Map<String, Object> updateTable(int id, TablesDTO tablesDTO) {
		// TODO Auto-generated method stub
		Tables tables = tablesDao.findByTableId(id);
		tables.setTableName(tablesDTO.getTableName());
		tables.setTableCapacity(tablesDTO.getTableCapacity());
		tables=	tablesDao.save(tables);
		return Collections.singletonMap("UpdatedId", tables.getTableId());
	}
	
	
}
