package com.twb.costlogistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.twb.costlogistics.entity.LogisticsCost;


//继承JpaRepository来完成对数据库的操作
public interface LogisticsCostRepository extends JpaRepository<LogisticsCost,Integer>,PagingAndSortingRepository<LogisticsCost,Integer>{
	
	@Query(value="select o from LogisticsCost o where destination =:destination")
	public List<LogisticsCost> getByDestination(@Param("destination") String destination) throws Exception;
	  
	
}
