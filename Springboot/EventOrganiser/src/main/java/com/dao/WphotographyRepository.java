package com.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

	import com.model.Wphotography;

	public interface WphotographyRepository extends JpaRepository<Wphotography, Integer>{



}
