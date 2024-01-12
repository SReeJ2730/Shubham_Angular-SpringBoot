package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Pmusic;

@Service

public class PmusicDao {
	@Autowired
	PmusicRepository pmusicRepository;
	
	public List<Pmusic> getPmusics() {
		return  pmusicRepository.findAll();
	}

	
	public void registerPmusic(Pmusic pmusic) {
		 pmusicRepository.save(pmusic);
	}
	
	public void updatePmusic(Pmusic pmusic) {
		 pmusicRepository.save(pmusic);
	}
	
}