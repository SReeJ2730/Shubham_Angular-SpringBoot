package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Cdrink;

@Service

public class CdrinkDao {
	@Autowired
	CdrinkRepository cdrinkRepository;
	
	public List<Cdrink> getCdrinks() {
		return  cdrinkRepository.findAll();
	}
	

	public void registerCdrink(Cdrink cdrink) {
		 cdrinkRepository.save(cdrink);
	}
	
	public void updateCdrink(Cdrink cdrink) {
		 cdrinkRepository.save(cdrink);
	}

}