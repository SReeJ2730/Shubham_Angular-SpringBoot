package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Ccatering;

@Service
public class CcateringDao {
	@Autowired
	CcateringRepository ccateringRepository;
	
	public List<Ccatering> getCcaterings() {
		return  ccateringRepository.findAll();
	}
	
	public void registerCcatering(Ccatering ccatering) {
		 ccateringRepository.save(ccatering);
	}
	
	public void updateCcatering(Ccatering ccatering) {
		 ccateringRepository.save(ccatering);
	}

}