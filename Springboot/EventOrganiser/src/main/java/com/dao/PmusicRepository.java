package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Pmusic;

public interface PmusicRepository extends JpaRepository<Pmusic, Integer> {


}