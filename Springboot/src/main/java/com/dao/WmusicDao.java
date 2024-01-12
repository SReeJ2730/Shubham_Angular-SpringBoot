package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Wmusic;

@Service

public class WmusicDao {
	@Autowired
	WmusicRepository wmusicRepository;
	
	public List<Wmusic> getWmusics() {
		return  wmusicRepository.findAll();
	}
	

	
	public void registerWmusic(Wmusic wmusic) {
		 wmusicRepository.save(wmusic);
	}
	
	public void updateWmusic(Wmusic wmusic) {
		 wmusicRepository.save(wmusic);
	}

}