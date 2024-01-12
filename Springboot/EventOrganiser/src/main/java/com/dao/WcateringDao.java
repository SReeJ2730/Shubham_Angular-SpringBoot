package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wcatering;

@Service

public class WcateringDao {
	@Autowired
	WcateringRepository wcateringRepository;
	
	public List<Wcatering> getWcaterings() {
		return  wcateringRepository.findAll();
	}
	
//	public Wcatering getWcateringByName(String eName) {
//		return  wcateringRepository.findByName(eName);
//	}
	
	public void registerWcatering(Wcatering wcatering) {
		 wcateringRepository.save(wcatering);
	}
	
	public void updateWcatering(Wcatering wcatering) {
		 wcateringRepository.save(wcatering);
	}
	
//	public void deleteWcateringByName() {
//		 wcateringRepository.deleteById(cId);
//	}
}
