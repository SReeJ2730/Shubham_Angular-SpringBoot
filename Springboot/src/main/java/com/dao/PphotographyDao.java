package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Pphotography;

@Service

public class PphotographyDao {
	@Autowired
	PphotographyRepository pphotographyRepository;
	
	public List<Pphotography> getPphotographys() {
		return  pphotographyRepository.findAll();
	}
	

	
	public void registerPphotography(Pphotography pphotography) {
		 pphotographyRepository.save(pphotography);
	}
	
	public void updatePphotography(Pphotography pphotography) {
		 pphotographyRepository.save(pphotography);
	}

}