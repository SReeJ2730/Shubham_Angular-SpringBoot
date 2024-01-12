package com.project.EventOrganiser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.dao.EventDao;
import com.dao.EventRepository;
import com.model.Event;

@RestController
public class EventController {

	@Autowired
	EventDao eventDao;
	@Autowired
	EventRepository eventRepository;
	
	@GetMapping("getEvents")
	public List<Event> getEvents() {
		return eventDao.getEvents();
	}
	
	@GetMapping("getEventById/{eventId}")
	public Event getEventById(@PathVariable("eId") int eventId) {
		return eventDao.getEventById(eventId);
	}
	
	@PostMapping("registerEvent")
	public String registerEvent(@RequestBody Event event) {
		eventDao.registerEvent(event);
		return "Event Registered Successfully!!!";
	}
	


	
	@PutMapping("updateEvent")
	public String updateEvent(@RequestBody Event event) {
		eventDao.updateEvent(event);
		return "Event Updated Successfully!!!";
	}
	
	@DeleteMapping("deleteEventById/{eId}")
	public String deleteEventById(@PathVariable("eId") int eId) {
		eventDao.deleteEventById(eId);
		return "Event Deleted Successfully!!!";
	}
	
	}
	
