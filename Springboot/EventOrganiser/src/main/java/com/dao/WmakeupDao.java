package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wmakeup;

@Service

public class WmakeupDao {
	@Autowired
	WmakeupRepository wmakeupRepository;
	
	public List<Wmakeup> getWmakeups() {
		return  wmakeupRepository.findAll();
	}
	
//	public Wmakeup getWmakeupByName(String eName) {
//		return  wmakeupRepository.findByName(eName);
//	}
	
	public void registerWcatering(Wmakeup wmakeup) {
		 wmakeupRepository.save(wmakeup);
	}
	
	public void updateWmakeup(Wmakeup wmakeup) {
		 wmakeupRepository.save(wmakeup);
	}
	
//	public void deleteWmakeupByName() {
//		 wmakeupRepository.deleteById(cId);
//	}
}