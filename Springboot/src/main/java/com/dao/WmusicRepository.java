package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Wmusic;

public interface WmusicRepository extends JpaRepository<Wmusic, Integer> {



}