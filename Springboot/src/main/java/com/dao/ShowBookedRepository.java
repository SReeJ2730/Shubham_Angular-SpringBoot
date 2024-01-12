package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Showbooked;

public interface ShowBookedRepository extends JpaRepository<Showbooked,Integer>{

	@Query("FROM Showbooked WHERE emailId = :emailId")
    List<Showbooked>  findByEmailId(@Param("emailId") String emailId);
     
 
   @Query("from Showbooked e ORDER BY e.date")
   List<Showbooked> getDetailsOrder();
   
   @Query("from Showbooked e where e.emailId= :email ORDER BY e.date")
   List<Showbooked> getDetailsOrderMail(@Param("email")String email);

	
	
	
}
