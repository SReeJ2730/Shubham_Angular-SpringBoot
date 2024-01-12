package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wdecoration;

@Service

public class WdecorationDao {
	@Autowired
	WdecorationRepository wdecorationRepository;
	
	public List<Wdecoration> getWdecorations() {
		return  wdecorationRepository.findAll();
	}
	
//	public Wcatering getWcateringByName(String eName) {
//		return  wcateringRepository.findByName(eName);
//	}
	
	public void registerWdecoration(Wdecoration wdecoration) {
		 wdecorationRepository.save(wdecoration);
	}
	
	public void updateWdecoration(Wdecoration wdecoration) {
		 wdecorationRepository.save(wdecoration);
	}
	
//	public void deleteWcateringByName() {
//		 wcateringRepository.deleteById(cId);
//	}
}