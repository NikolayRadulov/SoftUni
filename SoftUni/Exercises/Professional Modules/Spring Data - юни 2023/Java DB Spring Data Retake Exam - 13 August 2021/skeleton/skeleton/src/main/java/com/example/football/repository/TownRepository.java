package com.example.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.football.models.entity.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
	
	Town getByName(String name);
}
