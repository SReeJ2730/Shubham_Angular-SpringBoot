package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{

	@Query("from Event e where e.eventName = :eventName")
	Event findByName(@Param("eventName") String eventName);
	
	
	
}