package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Pdecoration;

@Service

public class PdecorationDao {
	@Autowired
	PdecorationRepository pdecorationRepository;
	
	public List<Pdecoration> getPdecorations() {
		return  pdecorationRepository.findAll();
	}
	

	
	public void registerPdecoration(Pdecoration pdecoration) {
		 pdecorationRepository.save(pdecoration);
	}
	
	public void updatePdecoration(Pdecoration pdecoration) {
		 pdecorationRepository.save(pdecoration);
	}

}