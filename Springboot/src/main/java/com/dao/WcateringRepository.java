package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Wcatering;

public interface WcateringRepository extends JpaRepository<Wcatering, Integer> {

//	@Query("from Wcatering w where w.name = :wname")
//	Wcatering findByName(@Param("wname") String wname);

}
