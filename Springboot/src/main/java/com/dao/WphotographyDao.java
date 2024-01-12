package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wphotography;

@Service

public class WphotographyDao {
	@Autowired
	WphotographyRepository wphotographyRepository;
	
	public List<Wphotography> getWphotographys() {
		return  wphotographyRepository.findAll();
	}

	
	public void registerWphotography(Wphotography wphotography) {
		wphotographyRepository.save(wphotography);
	}
	
	public void updateWphotography(Wphotography wphotography) {
		wphotographyRepository.save(wphotography);
	}

}
