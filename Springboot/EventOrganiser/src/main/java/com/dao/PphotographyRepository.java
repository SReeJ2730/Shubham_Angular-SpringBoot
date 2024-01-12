package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Pphotography;

public interface PphotographyRepository extends JpaRepository<Pphotography, Integer> {


}