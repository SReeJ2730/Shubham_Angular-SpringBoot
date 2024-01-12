package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.model.UserUniqueId;

public interface UserUniqueIdRepository  extends JpaRepository<UserUniqueId, Integer>{
	@Query("from UserUniqueId c where c.email = :emailId")
	UserUniqueId getDataByEmail(@Param("emailId") String emailId);
}