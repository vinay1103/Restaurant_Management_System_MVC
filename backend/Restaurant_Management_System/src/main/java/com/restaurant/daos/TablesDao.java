package com.restaurant.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Tables;

@Repository
public interface TablesDao extends JpaRepository<Tables, Integer> {

	List<Tables> findByWaiter_UserId(int waiterId);
	List<Tables> findByTableStatus(String status);
	Tables findByTableId(int tableId);

}
