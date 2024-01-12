package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Event;

@Service
public class EventDao {
	
	@Autowired
	EventRepository eventRepository;
	
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	public Event getEventById(int eventId) {
		return eventRepository.findById(eventId).orElse(new Event( 0,"Not Found", "",0,null,null));
	}
	
	public Event getEventByName(String eName) {
		return eventRepository.findByName(eName);
	}
	
	public void registerEvent(Event event) {
		eventRepository.save(event);
	}
	
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	
	public void deleteEventById(int cId) {
		eventRepository.deleteById(cId);
	}
	

}