package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Pcatering;

@Service

public class PcateringDao {
	@Autowired
	PcateringRepository pcateringRepository;
	
	public List<Pcatering> getPcaterings() {
		return  pcateringRepository.findAll();
	}
	
	
	public void registerPcatering(Pcatering pcatering) {
		 pcateringRepository.save(pcatering);
	}
	
	public void updatePcatering(Pcatering pcatering) {
		 pcateringRepository.save(pcatering);
	}
	
}