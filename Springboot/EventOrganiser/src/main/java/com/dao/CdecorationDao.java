package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Cdecoration;

@Service

public class CdecorationDao {
	@Autowired
	CdecorationRepository cdecorationRepository;
	
	public List<Cdecoration> getCdecorations() {
		return  cdecorationRepository.findAll();
	}
	

	public void registerCdecoration(Cdecoration cdecoration) {
		 cdecorationRepository.save(cdecoration);
	}
	
	public void updateCdecoration(Cdecoration cdecoration) {
		 cdecorationRepository.save(cdecoration);
	}
	

}